/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coreservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alumne
 */
public class RepeatVisitor extends HttpServlet {

@Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    HttpSession session = request.getSession();
    synchronized(session) {
      String heading;
      Integer accessCount =
        (Integer)session.getAttribute("accessCount");
      if (accessCount == null) {
        accessCount = 0;
        heading = "Welcome Aboard";
      } else {
        heading = "Welcome Back";
        accessCount = accessCount + 1;
      }
      // Integer is an immutable data structure. So, you
      // cannot modify the old one in-place. Instead, you
      // have to allocate a new one and redo setAttribute.
      session.setAttribute("accessCount", accessCount);
      PrintWriter out = response.getWriter();
      String title = "Session Tracking Example";
      String docType =
        "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
        "Transitional//EN\">\n";
      out.println(docType +
                  "<HTML>\n" +
                  "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                  "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                  "<CENTER>\n" +
                  "<H1>" + heading + "</H1>\n" +
                  "</CENTER></BODY></HTML>");
    }
  }
}
