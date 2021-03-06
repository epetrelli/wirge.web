package it.wirge.data;

import com.googlecode.objectify.ObjectifyService;
import it.wirge.data.model.Admin;
import it.wirge.data.model.BlogPost;
import it.wirge.data.model.StoredImage;
import it.wirge.data.model.UserMessage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Registers classes for data storage
 */
public class ObjectifyStartupServlet extends HttpServlet {

  private static final Logger logger = Logger.getLogger(ObjectifyStartupServlet.class.getName());

  static {
    ObjectifyService.register(UserMessage.class);
    ObjectifyService.register(BlogPost.class);
    ObjectifyService.register(Admin.class);
    ObjectifyService.register(StoredImage.class);
    logger.info("ObjectifyService created");
  }

}
