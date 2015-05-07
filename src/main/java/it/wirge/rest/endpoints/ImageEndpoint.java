package it.wirge.rest.endpoints;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.googlecode.objectify.Key;
import it.wirge.data.model.UploadUrl;
import it.wirge.data.model.UserMessage;
import it.wirge.rest.WirgeEndPoint;
import it.wirge.utils.Mailer;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

@Path("/images")
public class ImageEndpoint extends WirgeEndPoint {

  @GET
  @Produces({MediaType.APPLICATION_JSON})
  public List<UserMessage> findAll() {
    logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
    // Admins only
    verifyUserIsAdmin();
    return ofy().load().type(UserMessage.class).list();
  }

  @GET
  @Path("/uploadUrl")
  @Produces({MediaType.APPLICATION_JSON})
  public UploadUrl getUploadUrl() {
    logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
    // Admins only
    verifyUserIsAdmin();

    UploadUrl uploadUrl = new UploadUrl();
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    uploadUrl.setUrl(blobstoreService.createUploadUrl("/upload"));
    return uploadUrl;
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
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({MediaType.APPLICATION_JSON})
  public UserMessage create(UserMessage userMessage) {
    logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
    userMessage.setDhCreated(new Date());
    ofy().save().entity(userMessage).now();

    Mailer.sendMessage(
      "enrico.petrelli@wirge.it",
      "enrico.petrelli@wirge.it",
      "New Message",
      userMessage.getTxtMessage());

    return userMessage;
  }

  @PUT
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({MediaType.APPLICATION_JSON})
  public UserMessage update(UserMessage userMessage) {
    logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
    // Admins only
    verifyUserIsAdmin();
    return create(userMessage);
  }

  @DELETE
  @Path("{id}")
  public void remove(@PathParam("id") Long id) {
    logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "(" + id + ")");
    // Admins only
    verifyUserIsAdmin();
    ofy().delete().key(Key.create(UserMessage.class, id)).now();
  }
}
