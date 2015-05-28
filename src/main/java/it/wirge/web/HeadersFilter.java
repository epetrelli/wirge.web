package it.wirge.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Logger;

/**
 * Created by enricopetrelli on 04/03/15.
 */
public class HeadersFilter implements Filter
{
  Logger logger;

  @SuppressWarnings("nls")
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
  {
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;

    if (httpServletRequest.getHeader("origin")!=null)
    {
      httpServletResponse.addHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("origin"));
      httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, OPTIONS, DELETE");
      httpServletResponse.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Cookie, Set-Cookie");
      httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
    }


    try {

      chain.doFilter(httpServletRequest, httpServletResponse);

    }
    catch (IOException e) {

      e.printStackTrace();
      e.getCause().printStackTrace();

    }
    catch (ServletException e) {

      e.printStackTrace();
      e.getCause().printStackTrace();

    }
    catch (Exception e) {

      e.printStackTrace();
      e.getCause().printStackTrace();

    }


  }

  public HeadersFilter()
  {

  }

  public void init(FilterConfig fConfig) throws ServletException
  {
    this.logger = Logger.getLogger(this.getClass().getName());
  }

  public void destroy()
  {
    // nothing to do
  }

}

