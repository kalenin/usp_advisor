<%-- 
    Document   : change_password
    Created on : 03/12/2016, 18:02:52
    Author     : w
--%>

<%@page import="java.transacoes.studentsCO" %>
<%@page import="java.data.studentsDO" %>
<%@page import="java.util.Vector" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Mudar Senha</title>
        
<%     
       String action = request.getParameter("action");
       if ( null == action ) {
          action = "showMudarSenhaForm";
%>    
    
<form action="./change_password.jsp" method="post">
<%
    // verificando login
    if ( session.getAttribute("num_usp") == null) {
       pageContext.forward("login.jsp");
    }

%>
    

    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>Mudar Senha </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Senha Atual </td>
                    <td><input type="text" name="senha_atual" value="" /></td>
                </tr>
                <tr>
                    <td>Nova Senha </td>
                    <td><input type="text" name="new_password" value="" /></td>
                </tr>
                <tr>
                    <td>Confirmação da Nova Senha </td>
                    <td><input type="text" name="new_password_confirmation" value="" /></td>
                </tr>
            </tbody>
        </table>
	<input type="hidden" name="action" value="showMudarSenhaResults" />
</form>
<%        
       } 

%>
   
<%
     if (action.equals("showMudarSenhaResults")) {
       String password_hash = request.getParameter("password_hash");
       java.transacoes.studentsCO tn = new java.transacoes.studentsCO();
       Vector studentsCO = tn.pesquisar(password_hash);
       if ( (password_hash == null) || (password_hash.size() == 0)) { 
           // avisar usuario que a senha está incorreta
%>
            Senha Atual incorreta!
            <form action="./change_password.jsp" method="post">
             <input type="submit" name="voltar" value="Voltar" />
          </form>
   <%     } else
           {
%>
                
        <input type="hidden" name="action" value="showMudarSenhaConfResults" />
            
<%
        if (action.equals ("showMudarSenhaConfResults")) {
        String new_password = request.getParameter("new_password");
        String new_password_confirmation = request.getParameter("new_password_confirmation");
        if (new_password == new_password_confirmation) {
        }
        // senha nova é igual a confirmação da senha nova
%>
     <form action="./change_password.jsp" method="post">        
    <input type="submit" name="Mudar Senha" value="mudar_senha" />
     </form>
   <%     } else
           {
%>       
        

</body>
</html>
