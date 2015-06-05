package it.wirge.rest.endpoints;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.googlecode.objectify.Key;
import it.wirge.data.model.StoredImage;
import it.wirge.data.model.UploadUrl;
import it.wirge.data.model.UserMessage;
import it.wirge.rest.WirgeEndPoint;
import it.wirge.utils.Mailer;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.restlet.data.Status;
import org.restlet.ext.fileupload.RestletFileUpload;
import org.restlet.ext.jaxrs.internal.provider.FileUploadProvider;
import org.restlet.representation.Representation;
import org.restlet.resource.ResourceException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.*;

import static com.googlecode.objectify.ObjectifyService.ofy;

@Path("/images")
public class ImageEndpoint extends WirgeEndPoint {

  @GET
  @Produces({MediaType.APPLICATION_JSON})
  public List<StoredImage> findAll() {
    logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
    // Admins only
    verifyUserIsAdmin();
    return ofy().load().type(StoredImage.class).order("-dhCreated").list();
  }

  @GET
  @Path("{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public UserMessage findById(@PathParam("id") Long id) {
    logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "(" + id + ")");

    // Admins only
    verifyUserIsAdmin();

    UserMessage userMessage = ofy().load().key(Key.create(UserMessage.class, id)).now();
    if (userMessage == null) {
      throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
    }
    return userMessage;
  }

  @POST
  @Produces({MediaType.APPLICATION_JSON})
  public StoredImage create(Representation entity) throws UnsupportedEncodingException, FileUploadException {
    logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

    // Admins only
    verifyUserIsAdmin();

    // 1/ Create a factory for disk-based file items
    DiskFileItemFactory factory = new DiskFileItemFactory();
    factory.setSizeThreshold(1000240);

    StoredImage storedImage = new StoredImage();
    RestletFileUpload upload = new RestletFileUpload(factory);
    List<FileItem> items;

    try {
      // Request is parsed by the handler which generates a list of FileItems
      items = upload.parseRepresentation(entity);

      Map<String, String> props = new HashMap<>();

      for (final Iterator<FileItem> it = items.iterator(); it.hasNext(); ) {
        FileItem fi = it.next();
        String nmFile = fi.getName();

        if(ofy().load().type(StoredImage.class).filter("nmFile", nmFile).first().now()!=null){
          // Image already loaded: throw exception
          logger.info("A file with same name (" + nmFile + ") has already been uploaded");
          throw new ResourceException(Status.CLIENT_ERROR_CONFLICT);
        }

        if (nmFile == null) {
          logger.info(fi.getFieldName() + "=" + new String(fi.get(), "UTF-8"));
          props.put(fi.getFieldName(), new String(fi.get(), "UTF-8"));
        } else {
          logger.info("File: " + fi.getSize() + " bytes");
          byte[] baImageData = fi.get();
          ImagesService imagesService = ImagesServiceFactory.getImagesService();
          Image uploadedImage = ImagesServiceFactory.makeImage(baImageData);
          storedImage.setDhCreated(new Date());
          storedImage.setiOriginalW(uploadedImage.getWidth());
          storedImage.setiOriginalH(uploadedImage.getHeight());
          storedImage.setNmFile(nmFile);
          storedImage.setBaBytes(new Blob(baImageData));
        }
      }
      ofy().save().entity(storedImage).now();

    }
    catch (ResourceException re) {
      throw re;
    }
    catch (Exception e) {
      e.printStackTrace();
      throw e;
    }

    return storedImage;
  }

  @DELETE
  @Path("{idStoredImage}")
  public void remove(@PathParam("id") Long idStoredImage) {
    logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "(" + idStoredImage + ")");
    // Admins only
    verifyUserIsAdmin();
    ofy().delete().key(Key.create(StoredImage.class, idStoredImage)).now();
  }
}
