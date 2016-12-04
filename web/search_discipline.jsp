<%-- 
    Document   : search_difficulty
    Created on : 03/12/2016, 18:48:05
    Author     : Lucas
--%>


<%@page contentType="text/html" pageEncoding="windows-1252"%>

<%@ page import="java.util.Vector" %>
<%@ page import="java.transacoes.DisciplinesCo" %>
<%@ page import="java.data.disciplinesDO" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Busca por Disciplina</title>
    </head>
    <body>
<%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
%>
        <center>
            You are not logged in<br/>
            <a href="login.jsp">Please Login</a>
        </center>
<%
    }
    else {
%>
        <center>
            <h3>Digite o código da disciplina</h3>
            <br>
            <br>
                <form method="post" action=index.jsp>
                    Usuário <input type="text" name="usuario" />
                    Senha <input type="password" name="senha" />
                    <input type="submit" name="enviar" value="Enviar" />
                    <input type="hidden" name="campo_controle" />
                </form>
        
<%     if ( null != request.getParameter("pesquisar")) {  
       String dificulty_search = request.getParameter("dificuldade");
       java.transacoes.DisciplinesCo tn = new java.transacoes.DisciplinesCo();
       Vector disciplines = tn.pesquisar(dificulty_search);
       if ( (disciplines == null) || (disciplines.size() == 0)) {
         // avisar usuario que nao há disciplinas com este nome
%>       Nenhuma disciplina com esta dificuldade foi encontrada!
          <form action="./seach_difficulty.jsp" method="post">
             <input type="submit" name="voltar" value="Voltar" />
          </form>
            
<%      } else {
%>
          <table>
             <tr>
                <td>Sigla</td>
                <td>Nome</td>
             </tr>
<%           for(int i = 0; i < disciplines.size(); i++) {
             disciplinesDO disciplina = (disciplinesDO)disciplines.elementAt(i);
%>              <tr>
                  <td><%= disciplina.getcode() %></td>
                  <td><%= disciplina.getname() %></td>
                </tr>        
<%           } // for i      
%>        </table>            
<%    
        }
    }
}
%>
    </center>
    </body>
</html>
