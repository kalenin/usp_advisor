<%-- 
    Document   : search_quality
    Created on : Dec 3, 2016, 6:35:55 PM
    Author     : FGreco
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>

<%@ page import="java.util.Vector" %>
<%@ page import="java.transacoes.evaluationsCO" %>
<%@ page import="java.data.offeringsDO" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Busca por Qualidade</title>
    </head>
    <body>
<%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
%>
        <center>
            You are not logged in<br/>
            <br>
            <a href="index.jsp">Voltar a p&aacute;gina inicial</a>
        </center>
<%
    }
    else {
%>
        <center>
            <h3>Escolha uma mat&eacute;ria de acordo com sua did&aacute;tica</h3>
            <br>
            <br>
            <form method="post" action="./search_quality.jsp">
                <label>Did&aacute;tica:</label>
                <div>
                    <br>
                    <input name="quality" type="radio" value="1"> 1
                    <input name="quality" type="radio" value="2"> 2
                    <input name="quality" type="radio" value="3"> 3
                    <input name="quality" type="radio" value="4"> 4
                    <input name="quality" type="radio" value="5"> 5
                </div>
                <br>
                <br>
                <input type="submit" name="pesquisar" value="Pesquisar" />
            </form>
            <br>
            <br>
            <br>
<%   
    if ( null != request.getParameter("pesquisar")) {
        int search_quality = Integer.parseInt(request.getParameter("quality"));
        //Uso evaluationsCO para chamar a funcao pesquisarPorQuality
        java.transacoes.evaluationsCO eval_tr = new java.transacoes.evaluationsCO();
        Vector disciplines_list = eval_tr.pesquisarPorQuality(search_quality);
        if ( (disciplines_list == null) || (disciplines_list.size() == 0)) {
          //Se o vetor de resultados estiver vazio:
%>
            Nenhuma disciplina foi encontrada para as op&ccedil;&otilde;es escolhidas!
<%  
        }
        else {
            int of;
%>
            <table>
                <tr>
                    <td>C&oacute;digo</td>
                    <td>Did&aacute;tica</td>
                </tr>
<%
            for(int i = 0; i < disciplines_list.size(); i++) {
            //variaveis salvas, em ordem: semestre (oferecimento), codigo (disciplina), id (oferecimento)
                offeringsDO offer = (offeringsDO)disciplines_list.elementAt(i);
%>
                <tr>
                    <td><%= offer.getSemester() %></td>
                    <td><%= offer.getDiscipline_id() %></td>
                    <td><%= offer.getId() %></td>
                    <td><a href=result_discipline.jsp?action=showEditForm&id=<%= offer.getId() %>> Escolher turma</a>
                </tr>
            }
%>        
           </table>       
<%     
        } // if(encontrou resultados)
    } // if(pesquisou)
} //if(login)
%>
        </center>
    </body>
</html>
