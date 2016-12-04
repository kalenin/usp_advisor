package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.transacoes.studentsCO;
import java.data.studentsDO;
import java.util.Vector;

public final class change_005fpassword_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\">\r\n");
      out.write("        <title>Mudar Senha</title>\r\n");
      out.write("\r\n");
      out.write("        ");

            String action = request.getParameter("action");
            if (null == action) {
                action = "showMudarSenhaForm";
        
      out.write("    \r\n");
      out.write("\r\n");
      out.write("    <form action=\"./change_password.jsp\" method=\"post\">\r\n");
      out.write("        ");

            // verificando login
            if (session.getAttribute("num_usp") == null) {
                pageContext.forward("login.jsp");
            }

        
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <table border=\"1\">\r\n");
      out.write("            <thead>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th>Mudar Senha </th>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            <tbody>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Senha Atual </td>\r\n");
      out.write("                    <td><input type=\"text\" name=\"senha_atual\" value=\"\" /></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Nova Senha </td>\r\n");
      out.write("                    <td><input type=\"text\" name=\"new_password\" value=\"\" /></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Confirmação da Nova Senha </td>\r\n");
      out.write("                    <td><input type=\"text\" name=\"new_password_confirmation\" value=\"\" /></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </tbody>\r\n");
      out.write("        </table>\r\n");
      out.write("        <input type=\"hidden\" name=\"action\" value=\"showMudarSenhaResults\" />\r\n");
      out.write("</form>\r\n");
    }


      out.write("\r\n");
      out.write("\r\n");
    if (action.equals("showMudarSenhaResults")) {
        String senha_atual = request.getParameter("senha_atual");
        
    // avisar usuario que a senha está incorreta

      out.write("\r\n");
      out.write("Senha Atual incorreta!\r\n");
      out.write("<form action=\"./change_password.jsp\" method=\"post\">\r\n");
      out.write("    <input type=\"submit\" name=\"voltar\" value=\"Voltar\" />\r\n");
      out.write("</form>\r\n");
     } else {

      out.write("\r\n");
      out.write("\r\n");
      out.write("<input type=\"hidden\" name=\"action\" value=\"showMudarSenhaConfResults\" />\r\n");
      out.write("\r\n");
  }
    if (action.equals("showMudarSenhaConfResults")) {
        String new_password = request.getParameter("new_password");
        String new_password_confirmation = request.getParameter("new_password_confirmation");
        if (new_password == new_password_confirmation) {
        
        // senha nova é igual a confirmação da senha nova

      out.write("\r\n");
      out.write("            <form action=\"./change_password.jsp\" method=\"post\">        \r\n");
      out.write("            <input type=\"submit\" name=\"Mudar Senha\" value=\"mudar_senha\" />\r\n");
      out.write("            </form>\r\n");
     
       if (action.equals("updateValues")) {
       String nome = request.getParameter("nome");
       String telefone = request.getParameter("telefone");
       int id = Integer.parseInt(request.getParameter("id"));
       transacoes.Contato tn = new transacoes.Contato();
       data.ContatoDO contato = new data.ContatoDO();
       contato.setId(id);
       contato.setNome(nome);
       contato.setTelefone(telefone); 
       boolean result = false;
       try {
          result = tn.atualizar(contato);
       } catch (Exception e) {

      out.write("}\r\n");
 } else {
      out.write("       \r\n");
      out.write("        Nova Senha está diferente de Confirmação da Nova Senha!\r\n");
 } 
      out.write('\r');
      out.write('\n');
 } 
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
