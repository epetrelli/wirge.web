package it.wirge.data.dao;

import it.wirge.data.EMF;
import it.wirge.data.model.UserMessage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class UserMessageDao {

  private static EntityManagerFactory entityManagerFactory = EMF.get();

  public UserMessage save(UserMessage userMessage) {
    EntityManager entityManager = null;
    UserMessage userMessageOut = null;
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityManager.getTransaction().begin();
      if (userMessage.getId() == null) {
        userMessage.setDhCreated(new Date(System.currentTimeMillis()));
        entityManager.persist(userMessage);
        userMessageOut = userMessage;
      } else {
        userMessageOut = entityManager.merge(userMessage);
      }
      entityManager.flush();
      entityManager.getTransaction().commit();
    } catch (Exception ex) {
      if(entityManager!= null && entityManager.getTransaction()!=null && entityManager.getTransaction().isActive())
        entityManager.getTransaction().rollback();
      throw new RuntimeException(ex);
    } finally {
      if (entityManager != null && entityManager.isOpen())
        entityManager.close();
    }
    return userMessageOut;
  }

  public UserMessage findById(Long id){
    EntityManager entityManager = null;
    UserMessage userMessageOut = null;
    try {
      entityManager = entityManagerFactory.createEntityManager();
      userMessageOut = entityManager.find(UserMessage.class, id);
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    } finally {
      if (entityManager != null && entityManager.isOpen())
        entityManager.close();
    }
    return userMessageOut;
  }

  public List<UserMessage> findAll() {
    EntityManager entityManager = null;
    List<UserMessage> userMessages = null;
    try {
      TypedQuery<UserMessage> query = entityManager.createQuery("select um from UserMessage um", UserMessage.class);
      userMessages = query.getResultList();
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    } finally {
      if (entityManager != null && entityManager.isOpen())
        entityManager.close();
    }
    return userMessages;
  }

  public UserMessage delete(UserMessage userMessage) {
    EntityManager entityManager = null;
    UserMessage userMessageOut = null;
    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityManager.getTransaction().begin();
      entityManager.remove(userMessage);
      entityManager.flush();
      entityManager.getTransaction().commit();
    } catch (Exception ex) {
      entityManager.getTransaction().rollback();
      throw new RuntimeException(ex);
    } finally {
      if (entityManager != null && entityManager.isOpen())
        entityManager.close();
    }
    return userMessageOut;
  }

}
