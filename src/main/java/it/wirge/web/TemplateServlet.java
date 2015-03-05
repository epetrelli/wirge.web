package it.wirge.web;

import com.googlecode.objectify.Key;
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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * Created by enricopetrelli on 05/03/15.
 */
public class TemplateServlet extends HttpServlet {

  private Configuration cfg;
  static Logger logger = Logger.getLogger(TemplateServlet.class.getName());

  public void init() {
    logger.info("init()");
    cfg = new Configuration(Configuration.VERSION_2_3_22);
    cfg.setServletContextForTemplateLoading(getServletContext(), "templates");
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

    // based on request, here is found the right blogPost
    // which is the data-model
    // TODO
    BlogPost blogPost = ofy().load().key(Key.create(BlogPost.class, 4785074604081152l)).now();
    logger.info(blogPost.getNmTitle());

    // Get the templat object
    Template t = cfg.getTemplate("blogPost.ftl");

    // Prepare the HTTP response:
    // - Use the charset of template for the output
    // - Use text/html MIME-type
    resp.setContentType("text/html; charset=" + t.getEncoding());
    Writer out = resp.getWriter();

    // Merge the data-model and the template
    try {
      t.process(blogPost, out);
    } catch (TemplateException e) {
      throw new ServletException(
        "Error while processing FreeMarker template", e);
    }
  }
}
