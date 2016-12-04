<%-- 
    Document   : home
    Created on : Dec 3, 2016, 5:21:38 PM
    Author     : FGreco
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>USPAdvisor Home</title>
    </head>
    <body>
<%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
%>
        <center>
            You are not logged in<br/>
            <a href="index.jsp">Please Login</a>
        </center>
<%
    }
    else {
        String nome = (String)session.getAttribute("username");
%>
        <center>
            <h1>Bem vindo ao USPAdvisor, <%= nome %></h1>
            <br>
            <br>
            
            <br>
            <p>Pesquisar mat&eacute;ria por:
            <a href="search_discipline.jsp">c&oacute;digo</a>
            <br>
            <a href="search_difficulty.jsp">dificuldade</a>
            <br>
            <a href="search_quality.jsp">did&aacute;tica</a>
        </center>
<%
    }
%>
    </body>
</html>