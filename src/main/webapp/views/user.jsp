<%-- 
    Document   : user
    Created on : 30/11/2021, 19:21:12
    Author     : pol_m
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            User user = (User) session.getAttribute("pepe");
        %>
        <article>
            <p><%=user.getName()%></p>
            <p><%=user.getPassword()%></p>
        </article>
    </body>
</html>
