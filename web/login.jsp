<%-- 
    Document   : login
    Created on : 03/12/2016, 17:46:23
    Author     : Vini
--%>

<%@ page import="java.transacoes.studentsCO" %>
<%@ page import="java.data.studentsDO" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
<%
    if (request.getParameter("campo_controle") != null ) {
       
       String nusp = request.getParameter("nusp");
       String senha = request.getParameter("senha");
       
       java.transacoes.studentsCO stn = new java.transacoes.studentsCO();
       studentsDO student = stn.pesquisarPorNum_usp(nusp);
       
       if ((student.getNum_usp() == null) || (student.getNum_usp() == "")) {
         // avisar usuario que nao há disciplinas com este nome 
        // processa login
       }
        //boolean v = valida(user, passwd);
        String pwd = student.getPassword_hash();
        
        
        boolean v = pwd.equals(senha);
        if (v) {
           session.setAttribute("user_name", nusp);
           pageContext.forward("home.jsp");
        } else {
   %>
           Usuario ou Senha invalidos!
   <%
        }
    }
    // show login form
%>
    <form method="post" action=login.jsp>
       Usuário <input type="text" name="nusp" />
       Senha <input type="password" name="senha" />
       <input type="submit" name="enviar" value="Enviar" />
       <input type="hidden" name="campo_controle" />
    </form>
    </body>
</html>