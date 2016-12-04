<%-- 
    Document   : login
    Created on : 03/12/2016, 17:46:23
    Author     : Vini
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Login</title>
    </head>
    <body> 
        Tecle seu nome e senha
        para ter acesso ao sistema.
        <form action="login.jsp">
            <table>
                <tr>
                    <td>Nome</td>
                    <td><input type="text" name="nome" />
                </tr>      
                <tr>
                <td>Senha</td>
                <td><input type="password" name="pwd" />
                </tr>
            </table>
        <input type="submit" name="ok" value="Entrar" />
        </form>
    </body>
</html>
