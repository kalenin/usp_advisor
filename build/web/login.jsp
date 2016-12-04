<%-- 
    Document   : login
    Created on : 03/12/2016, 17:46:23
    Author     : Vini
--%>

<<<<<<< HEAD
<%@ page import="transacoes.studentsCO" %>
<%@ page import="data.studentsDO" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
=======
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
>>>>>>> 1aa1cd09b789311e78bf9d4a15a2fe240d86426e
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Login</title>
    </head>
<<<<<<< HEAD
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
=======
    <body> 
        Tecle seu nome e senha
        para ter acesso ao sistema.
        <form action="login.jsp">
            <table>
                <tr>
                    <td>Nome</td>
                    <td><input type="text" name="nome" />
                </tr>      
                <tr>
                <td>Senha</td>
                <td><input type="password" name="pwd" />
                </tr>
            </table>
        <input type="submit" name="ok" value="Entrar" />
        </form>
>>>>>>> 1aa1cd09b789311e78bf9d4a15a2fe240d86426e
    </body>
</html>
