<%-- 
    Document   : ChooseColors2
    Created on : 28-abr-2021, 23:59:38
    Author     : Usuario
--%>

<%@page import="coreservlets.ColorBean"%>
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
            
            background: <jsp:getProperty name="color" property="backgroundC"/>;
            color: <jsp:getProperty name="color" property="foregroundC"/>;
        }
        
    </style>
    <body>
        <h1>Show Colors (1)</h1>
        <p>blah blah blah</p>
    </body>
</html>
