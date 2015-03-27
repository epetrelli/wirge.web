package it.wirge.rest.endpoints;


import com.google.appengine.api.users.User;
import com.googlecode.objectify.Key;
import it.wirge.data.model.Admin;
import it.wirge.data.model.BlogPost;
import it.wirge.rest.WirgeEndPoint;
import org.restlet.Response;
import org.restlet.ext.servlet.ServletUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

@Path("/appAdmin")
public class AppAdminEndpoint extends WirgeEndPoint {

  @POST
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({MediaType.APPLICATION_JSON})
  public Admin isAppAdmin(Admin gaeUser) {

    logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "(" + gaeUser.getEmail() + ")");
    Admin admin = null;

    try {
      HttpServletResponse httpServletResponse = ServletUtils.getResponse(Response.getCurrent());
      admin = ofy().load().key(Key.create(Admin.class, gaeUser.getUserId())).now();

      if(admin!=null && admin.getIsAdmin()) {
        logger.info("Admin " + gaeUser.getEmail() + " found.");
        addAdminCookie(admin, httpServletResponse);
        return admin;
      }
      else{
        logger.info("Admin " + gaeUser.getEmail() + " not found.");
        List<Admin> admins = ofy().load().type(Admin.class).list();

        if(admins==null || admins.isEmpty()){
          logger.info(" - This is the first admin: inserting as admin:");
          gaeUser.setIsAdmin(Boolean.TRUE);
          addAdminCookie(gaeUser, httpServletResponse);
        }
        ofy().save().entity(gaeUser).now();
        logger.info(" - Inserted");
        return gaeUser;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  private void addAdminCookie(Admin admin, HttpServletResponse httpServletResponse){

    Cookie adminCookie = new Cookie("appAdmin", admin.getUserId());
    httpServletResponse.addCookie(adminCookie);
  }

  /*
  @GET
  @Path("{idBlogPost}")
  @Produces({MediaType.APPLICATION_JSON})
  public BlogPost findById(@PathParam("idBlogPost") Long idBlogPost) {
    logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "(" + idBlogPost + ")");

    // Admins only
    verifyUserIsAdmin();

    BlogPost blogPost = ofy().load().key(Key.create(BlogPost.class, idBlogPost)).now();
    if (blogPost == null) {
      throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
    }
    return blogPost;
  }

  @POST
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({MediaType.APPLICATION_JSON})
  public BlogPost create(BlogPost blogPost) {
    logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

    // Admins only
    verifyUserIsAdmin();

    if(blogPost.getIdBlogPost()==null) {
      blogPost.setDhCreated(new Date());
      blogPost.setPublished(false);
    }

    blogPost.setUlLink(Utils.toPrettyURL(blogPost.getNmTitle(), Constants.EXTENSION_HTML));

    ofy().save().entity(blogPost).now();
    return blogPost;
  }

  @PUT
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({MediaType.APPLICATION_JSON})
  public BlogPost update(BlogPost blogPost) {
    logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
    // Admins only
    verifyUserIsAdmin();
    return create(blogPost);
  }

  @DELETE
  @Path("{idBlogPost}")
  public void remove(@PathParam("idBlogPost") Long idBlogPost) {
    logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "(" + idBlogPost + ")");
    // Admins only
    verifyUserIsAdmin();
    ofy().delete().key(Key.create(BlogPost.class, idBlogPost)).now();
  }
  */
}
