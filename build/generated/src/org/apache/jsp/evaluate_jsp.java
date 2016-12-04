package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class evaluate_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\">\n");
      out.write("        <title>Busca por Qualidade</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");

    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {

      out.write("\n");
      out.write("        <center>\n");
      out.write("            You are not logged in<br/>\n");
      out.write("            <br>\n");
      out.write("            <a href=\"index.jsp\">Please Login</a>\n");
      out.write("        </center>\n");

    }
    else {

      out.write("\n");
      out.write("        <center>\n");
      out.write("                <h4>Avalie a disciplina ");
 
      out.write("</h4>\n");
      out.write("                <form method=\"post\" action=\"show_offering.jsp\">\n");
      out.write("                    <label>Dificuldade:</label>\n");
      out.write("                    <div>\n");
      out.write("                        <input name=\"dificuldade\" type=\"radio\" value=\"1\"> 1\n");
      out.write("                        <input name=\"dificuldade\" type=\"radio\" value=\"2\"> 2\n");
      out.write("                        <input name=\"dificuldade\" type=\"radio\" value=\"3\"> 3\n");
      out.write("                        <input name=\"dificuldade\" type=\"radio\" value=\"4\"> 4\n");
      out.write("                        <input name=\"dificuldade\" type=\"radio\" value=\"5\"> 5\n");
      out.write("                    </div>\n");
      out.write("                    <br>\n");
      out.write("                    <br>\n");
      out.write("                    <label>Didática dos professores:</label>\n");
      out.write("                    <div>\n");
      out.write("                        <input id=\"element_1\" name=\"qualidade\" type=\"radio\" value=\"1\"> 1\n");
      out.write("                        <input id=\"element_1\" name=\"qualidade\" type=\"radio\" value=\"2\"> 2\n");
      out.write("                        <input id=\"element_1\" name=\"qualidade\" type=\"radio\" value=\"3\"> 3\n");
      out.write("                        <input id=\"element_1\" name=\"qualidade\" type=\"radio\" value=\"4\"> 4\n");
      out.write("                        <input id=\"element_1\" name=\"qualidade\" type=\"radio\" value=\"5\"> 5\n");
      out.write("                    </div>\n");
      out.write("                    <br>\n");
      out.write("                    <br>\n");
      out.write("                    <input type=\"submit\" name=\"avaliar\" value=\"Enviar\" />\n");
      out.write("                </form>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            </center>\n");
      out.write("        ");

            }
        
      out.write("\n");
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
