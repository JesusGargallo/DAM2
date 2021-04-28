<%-- 
    Document   : ChooseColors3
    Created on : 29-abr-2021, 0:11:28
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
            <jsp:useBean id="color" class="coreservlets.ColorBean" scope="application"/>
            <jsp:setProperty name="color" property="*"/>
            
            background: <jsp:getProperty name="color" property="background"/>;
            color: <jsp:getProperty name="color" property="foreground"/>;
        }
        
    </style>
    <body>
        <h1>Show Colors (3)</h1>
        <p>blah blah blah</p>
    </body>
</html>
