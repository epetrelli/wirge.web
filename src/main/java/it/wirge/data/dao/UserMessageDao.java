package it.wirge.data.dao;

import com.googlecode.objectify.Key;
import static com.googlecode.objectify.ObjectifyService.ofy;
import it.wirge.data.model.UserMessage;

import java.util.List;


public class UserMessageDao {

  public UserMessage save(UserMessage userMessage) {

    ofy().save().entity(userMessage).now();

    return userMessage;
  }

  public UserMessage findById(Long id){
    return ofy().load().key(Key.create(UserMessage.class, id)).now();
  }

  public List<UserMessage> findAll() {
    return ofy().load().type(UserMessage.class).list();
  }

  public void delete(UserMessage userMessage) {
    ofy().delete().entity(userMessage).now();
  }

}
