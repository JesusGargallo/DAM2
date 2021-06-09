package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 
        int operand1, operand2, resultat;
        
         try{
             resultat = Integer.parseInt(String.valueOf(session.getAttribute("resultado")));
             operand1 = Integer.parseInt(String.valueOf(session.getAttribute("operand1")));
             operand2 = Integer.parseInt(String.valueOf(session.getAttribute("operand2")));
         
         }catch(Exception e){
             resultat = 0;
             operand1 = 0;
             operand2 = 0;
         }
        
        
      out.write("\n");
      out.write("        \n");
      out.write("  <form action=\"opera\">\n");
      out.write("\n");
      out.write("<label>Operador1:</label><br>\n");
      out.write("\n");
      out.write("<input type=\"number\" name=\"operand1\" value=");
      out.print(operand1);
      out.write("><br><br>\n");
      out.write("\n");
      out.write("<input type=\"radio\" name=\"operador\" value=\"suma\">\n");
      out.write("\n");
      out.write("<label for=\"male\">+</label><br>\n");
      out.write("\n");
      out.write("<input type=\"radio\" name=\"operador\" value=\"resta\">\n");
      out.write("\n");
      out.write("<label for=\"female\">-</label><br><br>\n");
      out.write("\n");
      out.write("<label>Operador2:</label><br>\n");
      out.write("\n");
      out.write("<input type=\"number\" name=\"operand2\" value=");
      out.print(operand2);
      out.write("><br><br>\n");
      out.write("\n");
      out.write("<input type=\"submit\" value=\"=\"><br>\n");
      out.write("\n");
      out.write("<br>\n");
      out.write("\n");
      out.write("<label>Resultat:</label>\n");
      out.write("\n");
      out.print(resultat );
      out.write("\n");
      out.write("\n");
      out.write("</form>      \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
