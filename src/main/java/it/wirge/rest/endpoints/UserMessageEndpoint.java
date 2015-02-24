package it.wirge.rest.endpoints;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.appengine.repackaged.com.google.api.client.util.DateTime;
import com.googlecode.objectify.Key;
import it.wirge.data.model.UserMessage;
import org.restlet.Response;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

@Path("/usermessages")
public class UserMessageEndpoint extends ServerResource {

  @GET
  @Produces({MediaType.APPLICATION_JSON})
  public List<UserMessage> findAll() {
    return ofy().load().type(UserMessage.class).list();
  }

  @GET
  @Path("{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public UserMessage findById(@PathParam("id") Long id) {

    // Admins only
    UserService userService = UserServiceFactory.getUserService();
    if(!userService.isUserLoggedIn() || !userService.isUserAdmin())
      throw new ResourceException(Status.CLIENT_ERROR_FORBIDDEN);

    UserMessage userMessage = ofy().load().key(Key.create(UserMessage.class, id)).now();
    if(userMessage==null) {
      throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
    }
    return userMessage;
  }

  @POST
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({MediaType.APPLICATION_JSON})
  public UserMessage create(UserMessage userMessage) {
    userMessage.setDhCreated(new Date());
    ofy().save().entity(userMessage).now();
    return userMessage;
  }

  @PUT
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({MediaType.APPLICATION_JSON})
  public UserMessage update(UserMessage userMessage) {

    // Admins only
    UserService userService = UserServiceFactory.getUserService();
    if(!userService.isUserLoggedIn() || !userService.isUserAdmin())
      throw new ResourceException(Status.CLIENT_ERROR_FORBIDDEN);

    return create(userMessage);
  }

  @DELETE
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({MediaType.APPLICATION_JSON})
  public void remove(UserMessage userMessage) {

    // Admins only
    UserService userService = UserServiceFactory.getUserService();
    if(!userService.isUserLoggedIn() || !userService.isUserAdmin())
      throw new ResourceException(Status.CLIENT_ERROR_FORBIDDEN);

    ofy().delete().entity(userMessage).now();
  }
}
