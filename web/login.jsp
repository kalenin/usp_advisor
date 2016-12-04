<%-- 
    Document   : login
    Created on : 03/12/2016, 17:46:23
    Author     : Vini
--%>

<%@ page import="transacoes.studentsCO" %>
<%@ page import="data.studentsDO" %>

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
//       out.println(nusp + "\n");
       String senha = request.getParameter("senha");
//       out.println(senha + "\n");

       transacoes.studentsCO stn  = new transacoes.studentsCO();
//         out.println(stn + "\n");

       studentsDO student = stn.pesquisarPorNum_usp(nusp);
         out.println(student + "\n");


       if(student != null ){
           
       
        if ((student.getNum_usp() == null) || (student.getNum_usp() == "")) {
        }
         //boolean v = valida(user, passwd);
         String pwd = student.getPassword_hash();


         boolean v = pwd.equals(senha);
         if (v) {
            session.setAttribute("num_usp", nusp);
            pageContext.forward("home.jsp");
         } else {
     %>
            Usuario ou Senha invalidos!
     <%
         }
     }
}
    // show login form
%>
    <form method="post" action=login.jsp>
       <label>Usuário </label> <input type="text" name="nusp" />
       <label>Senha </label><input type="password" name="senha" />
       <input type="submit" name="enviar" value="Enviar" />
       <input type="hidden" name="campo_controle" />
    </form>
    </body>
</html>