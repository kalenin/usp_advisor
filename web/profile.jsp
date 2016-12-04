<html>
<header>
  <title>profile.jsp</title>
</header>

<body bgcolor="white">
<%@ page import="java.util.Vector" %>
<%@ page import="java.transacoes.studentsCO" %>
<%@ page import="java.data.studentsDO" %>


<%
    // VERIFICACAO MANUAL DO LOGIN
    if ( session.getAttribute("userid") == null) {
       pageContext.forward("login.jsp");
    }

    String num_usp = (String)session.getAttribute("userid");
%>
    

Perfil de <%= num_usp %>

<%    
    java.transacoes.studentsCO tn = new java.transacoes.studentsCO();
    Vector students = tn.buscar(num_usp); //search students by num_usp
%>
          <table>
             <tr>
                <td>NUSP</td>
                <td>Ano Entrada</td>
                <td>Nome</td>
                <td>Email</td>
             </tr>
<%           for(int i = 0; i < students.size(); i++) {
                studentsDO student = (studentsDO)students.elementAt(i);
%>              <tr>
                   <td><%= student.getNum_usp() %></td>
                   <td><%= student.getEntry_year() %></td>
                   <td><%= student.getName() %></td>
                   <td><%= student.getEmail() %></td>
                </tr>        
<%           } // for i      
%>        </table>            
<%     } // contatos retornados
     } // pesquisar
%>


<a href="change_email.jsp">Alterar Email   </a>
<a href="change_password.jsp">Alterar Senha</a>



</body>
</html>
