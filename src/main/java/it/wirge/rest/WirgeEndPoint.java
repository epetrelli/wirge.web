package it.wirge.rest;

import it.wirge.Constants;
import org.restlet.Request;
import org.restlet.data.Status;
import org.restlet.ext.servlet.ServletUtils;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

/**
 * Created by enricopetrelli on 03/03/15.
 */
public class WirgeEndPoint extends ServerResource {

  public static final Logger logger = Logger.getLogger("WirgeEndPoint");

  public void verifyUserIsAdmin() {

    HttpServletRequest httpServletRequest = ServletUtils.getRequest(Request.getCurrent());

    if (httpServletRequest.getRequestURL().indexOf("localhost") < 0) {
      Cookie[] cookies = httpServletRequest.getCookies();
      boolean cookieFound = false;

      if (cookies != null) {
        for (Cookie cookie : cookies) {
          if (cookie.getName().equals("appAdmin")) {
            logger.info("Admin cookie found (" + cookie.getValue() + ")");
            return;
          }
        }
      }
      logger.info("Admin cookie NOT found: 403");
      throw new ResourceException(
        Status.CLIENT_ERROR_FORBIDDEN,
        Constants.ERROR_UNAUTHORIZED
      );
    }
  }
}
