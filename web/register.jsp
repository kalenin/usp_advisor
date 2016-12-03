<html>
<header>
  <title>Inserir Contato</title>
</header>

<body bgcolor="white">
<%@ page import="java.transacoes.students" %>
<%@ page import="java.data.studentsDO" %>

<! ------------------------------------------------------------>
<!--   se for o request inicial, mostrar somente o formulario -->

<%     if ( null == request.getParameterValues("incluir") ) {
%>
       <form action="./insert.jsp" method="post">
<%
    // VERIFICACAO MANUAL DO LOGIN
    if (session.getAttribute("userid") == null) {
       pageContext.forward("index.jsp");
    }

    String name = (String)session.getAttribute("userid");
%>
    Insira abaixo os seus dados:

           <table>
            <tr>
               <td>Número USP: </td>
               <td><input type="text" name="num_usp" />
            </tr>
            <tr>
               <td>Ano de Entrada: </td>
               <td><input type="text" name="entry_year" />
            </tr>
            <tr>
               <td>Nome: </td>
               <td><input type="text" name="name" />
            </tr>
            <tr>
               <td>Ano de Entrada</td>
               <td><input type="text" name="ent" />
            </tr>
            <tr>
               <td>Ano de Entrada</td>
               <td><input type="text" name="entry_year" />
            </tr>
          </table>
          <input type="submit" name="incluir" value="incluir" />
        </form>

<%      } else { 
%>
<! ------------------------------------------------------------------->
<!--   se nao for o request inicial, acionar a transacao de negocio -->


<%     String nome = request.getParameter("nome");
       String telefone = request.getParameter("telefone");
       transacoes.Contato tn = new transacoes.Contato();
       data.ContatoDO contato = new data.ContatoDO();
       contato.setNome(nome);
       contato.setTelefone(telefone); 
       if ( tn.incluir(contato)) {
         // avisar usuario que transacao foi feita com sucesso
%>
          Transação realizada com sucesso!
          <form action="./main.jsp" method="post">
             <input type="submit" name="voltar" value="Voltar" />
          </form>
<%     } else {
%>
          Erro ao incluir usuário            
          <form action="./insert.jsp" method="post">
             <input type="submit" name="retry" value="Repetir" />
          </form>
<%     }
       }
%>

</body>
</html>
