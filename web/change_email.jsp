<%-- 
    Document   : change_email
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
        <title>Mudar Email</title>

        <%
            String action = request.getParameter("action");
            if (null == action) {
                action = "showMudarEmailForm";
        %>    

    <form action="./change_email.jsp" method="post">
        <%
            // verificando login
            if (session.getAttribute("userid") == null) {
                pageContext.forward("login.jsp");
            }

        %>


    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>Mudar Email </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Novo Email </td>
                    <td><input type="text" name="new_email" value="" /></td>
                </tr>

            </tbody>
        </table>
        <input type="hidden" name="action" value="showMudarEmailResults" />
</form>
<%    }

%>

<%    if (action.equals("showMudarEmailResults")) {
        String email = request.getParameter("new_email");
        java.transacoes.studentsCO tn = new java.transacoes.studentsCO();
        java.data.studentDO aluno = new java.data.studentDO();
        aluno.setEmail(email);
        if(tn.atualizar()) {
%>
<p>Deu bom</p>
<%
    else {
%>
<p>Deu ruim </p>

<%
            }
        }
    }
%>

<input type="hidden" name="action" value="showMudarEmailConfResults" />



<%  
    if (action.equals("showMudarEmailConfResults")) {
        String new_email = request.getParameter("new_email");
%>
        <form action="./change_email.jsp" method="post">        
        <input type="submit" name="Mudar Email" value="mudar_email" />
        </form>      
 
<% } %>
</body>
</html>
