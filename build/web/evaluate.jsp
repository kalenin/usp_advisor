<%-- 
    Document   : evaluate
    Created on : Dec 3, 2016, 9:46:39 PM
    Author     : FGreco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.data.evaluationsDO" %>
<%@ page import="java.data.offeringsDO" %>
<%@ page import= "search_quality.jsp" %>


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
            <a href="index.jsp">Please Login</a>
        </center>
<%
    }
    else {
%>
        <center>
            <h4>Avalie a disciplina <% %></h4>
            <form method="post" action="show_offering.jsp">
                <label>Dificuldade:</label>
                <div>
                    <input name="difficulty" type="radio" value="1"> 1
                    <input name="difficulty" type="radio" value="2"> 2
                    <input name="difficulty" type="radio" value="3"> 3
                    <input name="difficulty" type="radio" value="4"> 4
                    <input name="difficulty" type="radio" value="5"> 5
                </div>
                <br>
                <br>
                <label>Didática dos professores:</label>
                <div>
                    <input name="quality" type="radio" value="1"> 1 <br> Pior
                    <input name="quality" type="radio" value="2"> 2
                    <input name="quality" type="radio" value="3"> 3
                    <input name="quality" type="radio" value="4"> 4
                    <input name="quality" type="radio" value="5"> 5 <br> Melhor
                </div>
                <br>
                <br>
                <input type="submit" name="avaliar" value="Enviar" />
            </form>
<%   
    if ( null != request.getParameter("avaliar")) {
        int difficulty = Integer.parseInt(request.getParameter("difficulty"));
        int quality = Integer.parseInt(request.getParameter("quality"));
        
        //Crio objeto de avaliacao e dou set em seus campos
        java.data.evaluationsDO eval = new java.data.evaluationsDO();
        eval.setDifficulty(difficulty);
        eval.setQuality(quality);
        eval.setOffering_id(offer.getDiscipline_id());
        eval.setStudent_id((Integer)session.getAttribute("userid"));
        
        //Crio o objeto de transacoes.avaliacao e chamo a funcao de incluir
        java.transacoes.evaluationsCO eval_tr = new java.transacoes.evaluationsCO();
        if (eval_tr.incluir(eval)) {
%>
            <p>Sua avalia&ccedil;&atilde;o foi enviada com sucesso</p>
<%
        }
        else {
%>
            <p>Houve uma falha para enviar sua avalia&ccedil;&atilde;o.</p>
            <br>
            <p>Tente novamente mais tarde.</p>
<%
        }
        
    } // if(pesquisou)
} //if(login)
%>
        </center>
    </body>
</html>
