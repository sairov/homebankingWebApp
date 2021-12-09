<%-- 
    Document   : user
    Created on : 30/11/2021, 19:21:12
    Author     : pol_m
--%>

<%@page import="database.UserDAO"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            boolean exists = (boolean) session.getAttribute("exists");

            if (exists) {      
            %>  
            <h1 class="m-5 text-success" >Acceso garantizado</h1>
            <h2 class="text-dark">Bienvenido al sistema</h2>
            <% 
               } else {
            %>
            <h1 class="m-5 text-danger" >Acceso denegado</h1>
            <a href="/" class="text-primary"> Volver al login</a>
            <% 
                }
            %> 
    </body>
</html>
