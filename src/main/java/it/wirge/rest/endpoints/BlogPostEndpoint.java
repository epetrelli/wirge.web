package it.wirge.rest.endpoints;


import com.googlecode.objectify.Key;
import it.wirge.Constants;
import it.wirge.Utils;
import it.wirge.data.model.BlogPost;
import it.wirge.rest.WirgeEndPoint;
import org.restlet.Request;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

@Path("/blogPosts")
public class BlogPostEndpoint extends WirgeEndPoint {

  @GET
  @Produces({MediaType.APPLICATION_JSON})
  public List<BlogPost> findAll() {
    logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

    // Admins only
    verifyUserIsAdmin();

    return ofy().load().type(BlogPost.class).list();
  }

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
    logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + "(" + blogPost.getNmTitle() + ") " + blogPost.getStoredImages().size() + " images");

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
}
