package it.wirge.rest.endpoints;

import it.wirge.data.dao.UserMessageDao;
import it.wirge.data.model.UserMessage;
import org.restlet.resource.ServerResource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/usermessages")
public class UserMessageEndpoint extends ServerResource {

  @GET
  @Produces({MediaType.APPLICATION_JSON})
  public List<UserMessage> findAll() {
    UserMessageDao userMessageDao = new UserMessageDao();
    List<UserMessage> userMessages = userMessageDao.findAll();
    return userMessages;
  }

  @GET
  @Path("{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public UserMessage findById(@PathParam("id") Long id) {
    UserMessageDao userMessageDao = new UserMessageDao();
    UserMessage userMessage = userMessageDao.findById(id);
    return userMessage;
  }

  @POST
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({MediaType.APPLICATION_JSON})
  public UserMessage create(UserMessage userMessage) {
    UserMessage userMessageOut;
    UserMessageDao userMessageDao = new UserMessageDao();
    userMessageOut = userMessageDao.save(userMessage);
    return userMessageOut;
  }

  @PUT
  @Path("{id}")
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({MediaType.APPLICATION_JSON})
  public UserMessage update(@PathParam("id") Long id, UserMessage userMessage) {

    if (!id.equals(userMessage.getId()))
      return null;

    UserMessage userMessageOut;
    UserMessageDao userMessageDao = new UserMessageDao();
    userMessageOut = userMessageDao.save(userMessage);

    return userMessageOut;
  }

  @DELETE
  @Path("{id}")
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({MediaType.APPLICATION_JSON})
  public void remove(@PathParam("id") Long id, UserMessage userMessage) {

    if (!id.equals(userMessage.getId()))
      return;

    UserMessageDao userMessageDao = new UserMessageDao();
    userMessageDao.delete(userMessage);
  }
}
