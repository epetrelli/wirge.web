package it.wirge.data;

import com.googlecode.objectify.ObjectifyService;
import it.wirge.data.model.UserMessage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by enricopetrelli on 23/02/15.
 */
public class ObjectifyStartupServlet extends HttpServlet {

  static {
    ObjectifyService.register(UserMessage.class);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
