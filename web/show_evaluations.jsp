<%-- 
    Document   : show_evaluations
    Created on : 04/12/2016, 15:26:48
    Author     : Palo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.transacoes.evaluationsCO" %>
<%@ page import="java.data.evaluationsDO" %>
<%@ page import="java.sql.*" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AvaliUSP - Avaliações</title>
    </head>
    <body>

    	<h1>Página MOSTRAR AVALIAÇÕES AvaliUSP</h1>
                 <form method="post">
<%
    // VERIFICACAO MANUAL DO LOGIN
    if ( session.getAttribute("user_name") == null) {
       pageContext.forward("index.jsp");
    }

    String nome1 = (String)session.getAttribute("user_name");
%>
    Bom dia <%= nome1 %> !!
           <table>
             <tr>
               <td>Nome para pesquisar: </td>
               <td><input type="text" name="nome" />
             </tr>
           </table>
           <input type="submit" name="pesquisar" value="pesquisar" />
           <input type="submit" name="voltar" value="voltar" />
         </form>
        
    </body>
</html>
