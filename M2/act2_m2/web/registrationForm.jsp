<%-- 
    Document   : registrationForm
    Created on : 16/04/2021, 17:28:12
    Author     : Alumne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet"
        href="./css/styles.css"
        type="text/css"/>
    </head>
    <body>
        <h1>Registrator Form</h1>
        
        <%String fname = String.valueOf(session.getAttribute("fname"));%>
        <%String fname2 = String.valueOf(session.getAttribute("fname2"));%>
        <%String email = String.valueOf(session.getAttribute("email"));%>
        
        <ul>
            <li><b>First Name: </b> <%=fname%></li>
            <li><b>Last Name: </b> <%=fname2%></li>
            <li><b>Email Address: </b> <%=email%></li>
            
            
        </ul>
    </body>
</html>
