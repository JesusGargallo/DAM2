<%-- 
    Document   : ChooseColors1
    Created on : 28/04/2021, 20:44:43
    Author     : Alumne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        body {
            background-color: <%=session.getAttribute("background")%>;
            color: <%=session.getAttribute("foreground")%>;
        }
        
    </style>
    <body>
        <h1>Show Colors (1)</h1>
        <p>blah blah blah</p>
    </body>
</html>
