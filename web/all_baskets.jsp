<%-- 
    Document   : all_baskets
    Created on : Sep 24, 2017, 8:52:37 PM
    Author     : strogiy.otec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%

            out.print("<h1>" + request.getAttribute("adidas") + " Adidas" + "</h1>");
            out.print("<h1>" + request.getAttribute("nike") + " Nike" + "</h1>");
            out.print("<h1>" + request.getAttribute("muit") + " MUIT" + "</h1>");
            out.print("<h1>" + request.getAttribute("sum") + " Total Sum" + "</h1>");
        %>
    </body>
</html>
