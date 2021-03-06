package it.wirge.web;

import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.Transform;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import it.wirge.Constants;
import it.wirge.Utils;
import it.wirge.data.model.BlogPost;
import it.wirge.data.model.StoredImage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.logging.Logger;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * Created by enricopetrelli on 05/28/15.
 */
public class ImagesServlet extends HttpServlet {

  static Logger logger = Logger.getLogger(ImagesServlet.class.getName());

  public void init() {
    logger.info("init()");
  }

  protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    throws ServletException, IOException {

    String sCompletePath = httpServletRequest.getRequestURI();
    logger.info("Request for " + sCompletePath);

    String[] saCompletePath = sCompletePath.split("\\/");
    String nmFile = saCompletePath[saCompletePath.length-1];
    Integer iWidth = null;
    StoredImage storedImage = null;

    // Tries to find the width: if present, it is the token before image name
    try {
      iWidth = new Integer(saCompletePath[saCompletePath.length-2]);
    } catch (NumberFormatException e) {
      logger.info("Image size not specified");
    }

    // Tries to retreive the image by name
    storedImage = ofy().load().type(StoredImage.class).filter("nmFile", nmFile).first().now();

    if(storedImage == null) {
      //logger.info("Not found by name: probably deleted; search by blogpost");
      boolean useNext = false;
      for(String sToken : saCompletePath){

        if(useNext){
          //logger.info("BlogPost: " + sToken);
          BlogPost blogPost = ofy().load().type(BlogPost.class).filter("ulLink", Utils.toPrettyURL(sToken, Constants.EXTENSION_HTML)).first().now();
          if(blogPost!=null){
            for(StoredImage blogPostStoredImage : blogPost.getStoredImages()){
              if(blogPostStoredImage.getNmFile().equals(nmFile)) {
                storedImage = blogPostStoredImage;
                break;
              }
            }
          }
          break;
        }

        if(sToken.equals("blogImages")){
          //logger.info("blogImages token found");
          useNext = true;
        }

      }
    }

    if(storedImage==null){
      httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
      return;
    }

    byte[] baImageData;
    if(iWidth !=null && iWidth < storedImage.getiOriginalW()) {
      logger.info("Image " + nmFile + " found: resizing to " + iWidth + "px wide");
      ImagesService imagesService = ImagesServiceFactory.getImagesService();
      Integer iHeight = Math.round(storedImage.getiOriginalH() * iWidth / storedImage.getiOriginalW());
      Image oldImage = ImagesServiceFactory.makeImage(storedImage.getBaBytes().getBytes());
      Transform transform = ImagesServiceFactory.makeResize(iWidth, iHeight);
      Image newImage = imagesService.applyTransform(transform, oldImage);
      baImageData = newImage.getImageData();
    }
    else{
      baImageData = storedImage.getBaBytes().getBytes();
    }

    httpServletResponse.setContentType("image/jpg");
    OutputStream outputStream = httpServletResponse.getOutputStream();
    outputStream.write(baImageData);
    outputStream.flush();
    outputStream.close();
  }
}
