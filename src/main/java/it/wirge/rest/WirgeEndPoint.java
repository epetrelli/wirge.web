package it.wirge.rest;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import java.util.logging.Logger;

/**
 * Created by enricopetrelli on 03/03/15.
 */
public class WirgeEndPoint extends ServerResource {

  public static final Logger logger = Logger.getLogger("WirgeEndPoint");

  public void verifyUserIsAdmin(){
    UserService userService = UserServiceFactory.getUserService();
    if (!userService.isUserLoggedIn() || !userService.isUserAdmin())
      throw new ResourceException(Status.CLIENT_ERROR_FORBIDDEN);
  }

}
