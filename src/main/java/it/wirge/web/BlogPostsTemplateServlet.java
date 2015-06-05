package it.wirge.web;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import it.wirge.data.model.BlogPost;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * Created by enricopetrelli on 05/03/15.
 */
public class BlogPostsTemplateServlet extends HttpServlet {

  private Configuration cfg;
  static Logger logger = Logger.getLogger(BlogPostsTemplateServlet.class.getName());

  public void init() {
    logger.info("init()");
    cfg = new Configuration(Configuration.VERSION_2_3_22);
    cfg.setServletContextForTemplateLoading(getServletContext(), "/templates");
  }

  protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    throws ServletException, IOException {

    Map<String, Object> model = new HashMap<String, Object>();
    List<BlogPost> blogPosts = ofy().load().type(BlogPost.class).order("-dhCreated").list();
    model.put("blogPosts", blogPosts);

    // Get the templat object
    Template t = cfg.getTemplate("blogPosts.ftl");

    // Prepare the HTTP response:
    // - Use the charset of template for the output
    // - Use text/html MIME-type
    httpServletResponse.setContentType("text/html; charset=" + t.getEncoding());
    Writer out = httpServletResponse.getWriter();

    // Merge the data-model and the template
    try {
      t.process(model, out);
    } catch (TemplateException e) {
      e.printStackTrace();
      throw new ServletException(
        "Error while processing FreeMarker template", e);
    }
  }
}
