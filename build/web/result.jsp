<%-- 
    Document   : result
    Created on : Sep 24, 2017, 7:13:23 PM
    Author     : strogiy.otec
--%>

<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            final Enumeration<String> paramNames = session.getAttributeNames();
            while (paramNames.hasMoreElements()) {
            final String element = paramNames.nextElement();
            session.getAttribute(element);
            if(!element.contains("org"))
            out.print("<h1>"+element+" = "+session.getAttribute(element)+"</h1>");
        }

            
            %>
    </body>
</html>
