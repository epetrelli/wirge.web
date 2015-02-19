package it.wirge.rest;

import org.restlet.Context;
import org.restlet.ext.jaxrs.JaxRsApplication;
/**
 * Created by enricopetrelli on 16/01/15.
 */
public class RestletJaxRsApplication extends JaxRsApplication {

  public RestletJaxRsApplication(Context context) {
    super(context);
    this.add(new RestletApplication());
  }

}
