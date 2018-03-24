<%-- 
    Document   : error
    Created on : Sep 21, 2017, 12:17:23 PM
    Author     : strogiy.otec
--%>

<%@page import="lab4.entities.ErrorMessage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <%
                final ErrorMessage message = (ErrorMessage) request.getAttribute("errorMessage");
                out.print("<p style=\"color:red;\">"+message.getErrorMessage()+"</p>");
                
            %>
            
        </h1>
    </body>
</html>
