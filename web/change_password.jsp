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
                    <td><input type="password" name="senha_atual" value="" /></td>
                </tr>
                <tr>
                    <td>Nova Senha </td>
                    <td><input type="password" name="nova_senha" value="" /></td>
                </tr>
                <tr>
                    <td>Confirma��o da Nova Senha </td>
                    <td><input type="password" name="confirmacao_nova_senha" value="" /></td>
                </tr>
            </tbody>
        </table>
        <input type="submit" name="Mudar Senha" value="mudar_senha" />
	<input type="hidden" name="action" value="showSearchResults" />
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
         // avisar usuario que a senha est� incorreta
%>

</body>
</html>
