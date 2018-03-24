<%-- 
    Document   : show
    Created on : Sep 23, 2017, 11:10:38 AM
    Author     : strogiy.otec
--%>

<%@page import="lab4.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%

            final User user = (User) session.getAttribute("user");
            out.print("<h1>Your name: " + user.getName() + "</h1>");
            out.print("<h1>Your age " + user.getAge() + "</h1>");
            out.print("<h1>Your login " + user.getLogin() + "</h1>");
        %>
        
        <br>
        <br>
        <br>
        <form action="/Lab4/users" method="delete">
             <input type="submit" value="Exit">
            
        </form>
        
    </body>
</html>
