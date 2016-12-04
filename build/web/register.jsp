<html>
<header>
  <title>Inserir Contato</title>
</header>

<body bgcolor="white">
<%@ page import="java.transacoes.studentsCO" %>
<%@ page import="java.data.studentsDO" %>

<! ------------------------------------------------------------>
<!--   se for o request inicial, mostrar somente o formulario -->

<%     if ( null == request.getParameterValues("incluir") ) {
%>
       <form action="./register.jsp" method="post">
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
               <td>Email: </td>
               <td><input type="text" name="email" />
            </tr>
            <tr>
               <td>Senha: </td>
               <td><input type="text" name="password_hash" />
            </tr>
          </table>
          <input type="submit" name="incluir" value="incluir" />
        </form>

<%      } else { 
%>
<! ------------------------------------------------------------------->
<!--   se nao for o request inicial, acionar a transacao de negocio -->


<%     String num_usp = request.getParameter("num_usp");
       String entry_year = request.getParameter("entry_year");
       String name = request.getParameter("name");
       String email = request.getParameter("email");
       String password_hash = request.getParameter("password_hash");
       transacoes.StudentsCo tn = new transacoes.StudentsCo();
       java.data.studentsDO student = new java.data.studentsDO();
       student.setNum_usp(num_usp);
       student.setEntry_year(Integer.parseInt(entry_year));
       student.setName(name);
       student.setEmail(email);
       student.setPassword_hash(password_hash);
       
       if (tn.incluir(student)) {
         // avisar usuario que transacao foi feita com sucesso
%>
          Cadastro realizada com sucesso!
          <form action="./home.jsp" method="post">
             <input type="submit" name="voltar" value="Voltar" />
          </form>
<%     } else {
%>
          Erro ao incluir usuário            
          <form action="./register.jsp" method="post">
             <input type="submit" name="retry" value="Repetir" />
          </form>
<%     }
       }
%>

</body>
</html>
