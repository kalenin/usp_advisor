package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.transacoes.studentsCO;
import java.data.studentsDO;
import java.util.Vector;

public final class change_005femail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write(' ');
      out.write("\n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <!DOCTYPE html>\n");
      out.write("    <html>\n");
      out.write("        <head>\n");
      out.write("            <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\">\n");
      out.write("            <title>Mudar Email</title>\n");
      out.write("\n");
      out.write("            ");

                String action = request.getParameter("action");
                if (null == action) {
                    action = "showMudarEmailForm";
            
      out.write("    \n");
      out.write("\n");
      out.write("        <form action=\"./change_email.jsp\" method=\"post\">\n");
      out.write("            ");

                // verificando login
                if (session.getAttribute("userid") == null) {
                    pageContext.forward("login.jsp");
                }

            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </head>\n");
      out.write("        <body>\n");
      out.write("            <table border=\"1\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Mudar Email </th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Novo Email </td>\n");
      out.write("                        <td><input type=\"text\" name=\"new_email\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"showMudarEmailResults\" />\n");
      out.write("    </form>\n");
      out.write("    ");
    }

    
      out.write("\n");
      out.write("\n");
      out.write("    ");
    if (action.equals("showMudarEmailResults")) {
            String email = request.getParameter("new_email");
            java.transacoes.studentsCO tn = new java.transacoes.studentsCO();
            java.data.studentsDO aluno = new java.data.studentsDO();
            aluno.setEmail(email);
            if(tn.atualizar(aluno)) {
    
      out.write("\n");
      out.write("               <p>Deu bom</p>\n");
      out.write("    ");

            } else {
    
      out.write("\n");
      out.write("                <p>Deu ruim </p>\n");
      out.write("    ");

                }
            }

    
      out.write("\n");
      out.write("\n");
      out.write("    <input type=\"hidden\" name=\"action\" value=\"showMudarEmailConfResults\" />\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    ");
  
  //      if (action.equals("showMudarEmailConfResults")) {
  //         String new_email = request.getParameter("new_email");
    
      out.write("\n");
      out.write("  ");
  //        <form action="./change_email.jsp" method="post">        
   //         <input type="submit" name="Mudar Email" value="mudar_email" />
   //         </form>      

     }   
      out.write("\n");
      out.write("    </body>\n");
      out.write("    </html>\n");
      out.write("\n");
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
