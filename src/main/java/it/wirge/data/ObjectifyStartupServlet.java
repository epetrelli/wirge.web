package it.wirge.data;

import com.googlecode.objectify.ObjectifyService;
import it.wirge.data.model.UserMessage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by enricopetrelli on 23/02/15.
 */
public class ObjectifyStartupServlet extends HttpServlet {

  private static final Logger logger = Logger.getLogger(ObjectifyStartupServlet.class.getName());

  // Registers classes for data storage
  static {
    ObjectifyService.register(UserMessage.class);
    logger.info("ObjectifyService created");
  }

}
