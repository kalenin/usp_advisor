<%-- 
    Document   : new_discpline.jsp
    Created on : Dec 3, 2016, 5:57:32 PM
    Author     : andrehamada
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
<header>
    <title>Inserir mat�ria</title>
</header>
    
    
<body>
<%@ page import="transacoes.Contato" %>
<%@ page import="data.ContatoDO" %>

<! -------------------------------->

<%  if (null = request.getParameterValues("incluir")) {
%>
    <form action="./insert.jsp" method="post">
        <%
            //Verificacao manual do login
        if (session.getAttribute("user_name") == null){
            pageContext.forward("index.jsp");
        }
        
        String materia = (String)session.getAttribute("name");
        String codigo = (String)session.getAttribute("code");
        String descricao = (String)session.getAttribute("description");
        %>
        
	<table>        
            <tr> 
                <td>Nome da mat�ria</td>
                <td><input maxlength="7" type="text" name="name" placeholder="ex:PMR3305" />
            </tr>
            <tr>
                <td>C�digo da Mat�ria</td>
                <td><input type="text" name="code" 
                           style="width: 400px"
                           placeholder="ex: Sistemas de Informa��o para Mecatr�nica">   
            </tr>    
        </table>
        <tr>Descri��o da mat�ria</tr>
	<textarea  rows="3" columns="80" maxlength="200" style="width: 400px; height: 50px" 
		name="descricao" placeholder="M�ximo de 200 caracteres" form="form_materia"
	></textarea>
        
        <input type="Submit" name="Cadastrar">
    </form>
     
 <% } else {
%>
<!----------------------------->
<%      String nome = request.getParameter("nome");
        String codigo = request.getParameter("codigo");
        String descricao = request.getParameter("descricao");
        
        
  
  
        
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Inserir mat�ria</title>
    </head>
    
</body>

   
</html>
