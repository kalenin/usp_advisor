<%-- 
    Document   : show_comments
    Created on : 04/12/2016, 02:22:35
    Author     : w
--%>

<<<<<<< HEAD
<html>
<header>
  <title>Coment�rios</title>
</header>

<body bgcolor="white">
<%@ page import="java.transacoes.commentsCO" %>
<%@ page import="java.data.commentsDO" %>
<%@ page import="java.util.Vector" %>

<! ------------------------------------------------------------------------->
<!--   se for o request inicial, mostrar somente o formulario de pesquisa -->

<%     
       String action = request.getParameter("action");
       if ( null == action ) {
          action = "showSearchForm";
%>

	  <form action="./show_comments.jsp" method="post">
<%
    // VERIFICACAO MANUAL DO LOGIN
    if ( session.getAttribute("num_usp") == null) {
       pageContext.forward("index.jsp");
    }

    String nome1 = (String)session.getAttribute("user_name");
%>
            <table>
              <tr>
                 <td>C�digo da Mat�ria </td>
                 <td><input type="text" name="code" />
              </tr>
            </table>
            <input type="submit" name="pesquisar" value="pesquisar" />
	    <input type="hidden" name="action" value="showSearchResults" />
          </form>

<%        
       } 

%>
<! ------------------------------------------------------------------------->
<!--   faz a pesquisa e mostra os resultados                              -->
<%
     if (action.equals("showSearchResults")) {
       String code = request.getParameter("code");
       transacoes.Contato tn = new transacoes.Contato();
       Vector contatos = tn.pesquisar(nome);
       if ( (contatos == null) || (contatos.size() == 0)) {
         // avisar usuario que nao ha' contatos com este nome
%>
          Nenhum contato com este nome foi encontrado!
          <form action="./main.jsp" method="post">
             <input type="submit" name="voltar" value="Voltar" />
          </form>
<%     } else {
%>
          <table>
             <tr>
                <td>Nome</td>
                <td>Telefone</td>
             </tr>
<%           for(int i = 0; i < contatos.size(); i++) {
                ContatoDO contato = (ContatoDO)contatos.elementAt(i);
%>              <tr>
                   <td><%= contato.getNome() %></td>
                   <td><%= contato.getTelefone() %></td>
		   <td><a href=update.jsp?action=showEditForm&id=<%= contato.getId()%>>Editar</a>
                </tr>        
<%           } // for i      
%>        </table>            
<%     } // contatos retornados

     } // pesquisar

%>
<! ------------------------------------------------------------------->
<!--   mostra formulario para atualizacao                           -->
<%     if (action.equals("showEditForm")) {
          int id = Integer.parseInt(request.getParameter("id"));
	  transacoes.Contato tn = new transacoes.Contato();
          data.ContatoDO contato = tn.buscar(id);
%>        
          <form action="./update.jsp" method="post">
             <table>
               <tr>
                  <td>Nome</td>
                  <td><%= contato.getNome() %> </td>
               </tr>
               <tr>
                  <td>Telefone</td>
                  <td><input type="text" name="telefone" value=<%= contato.getTelefone() %> />
               </tr>
             </table>
             <input type="submit" name="atualizar" value="atualizar" />
	     <a href="main.jsp">Voltar</a>
	     <input type="hidden" name="id" value=<%= id %> />
	     <input type="hidden" name="action" value="updateValues" />
	     <input type="hidden" name="nome" value=<%= contato.getNome() %> />
           </form>
<%         
       } // showEditForm
%>

<! ------------------------------------------------------------------->
<!--   atualizar valores -->
<%     
     if (action.equals("updateValues")) {
       String nome = request.getParameter("nome");
       String telefone = request.getParameter("telefone");
       int id = Integer.parseInt(request.getParameter("id"));
       transacoes.Contato tn = new transacoes.Contato();
       data.ContatoDO contato = new data.ContatoDO();
       contato.setId(id);
       contato.setNome(nome);
       contato.setTelefone(telefone); 
       boolean result = false;
       try {
          result = tn.atualizar(contato);
       } catch (Exception e) {
%>           <%= e.toString() %>
<%
       }
       if ( result ) {
         // avisar usuario que transacao foi feita com sucesso
%>
          Transa��o realizada com sucesso!
          <form action="./main.jsp" method="post">
             <input type="submit" name="voltar" value="Voltar" />
          </form>
<%     } else {
%>
          Erro ao atualizar dados do contato
          <form action="./update.jsp" method="post">
             <input type="submit" name="retry" value="Repetir" />
          </form>
<%     }
     } // updateValues
%>

</body>
=======

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
>>>>>>> 1b521f488b2e3b9b6375ecfeb13d91666dc396c5
</html>
