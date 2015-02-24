package it.wirge.rest;

import it.wirge.rest.endpoints.UserMessageEndpoint;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class RestletApplication extends Application {



  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> resourceClasses = new HashSet<Class<?>>();

    resourceClasses.add(UserMessageEndpoint.class);

    return resourceClasses;
  }
}
