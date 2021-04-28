<%-- 
    Document   : ChooseColors2
    Created on : 28-abr-2021, 23:59:38
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        body{
            <jsp:useBean id="color" class="coreservlets.ColorBean" scope="session"/>
            <jsp:setProperty name="color" property="*"/>
            
            background: <jsp:getProperty name="color" property="background"/>;
            color: <jsp:getProperty name="color" property="foreground"/>;
        }
        
    </style>
    <body>
        <h1>Show Colors (2)</h1>
        <p>blah blah blah</p>
    </body>
</html>
