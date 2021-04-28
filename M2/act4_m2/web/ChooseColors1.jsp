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
    <body>
        <form action="showcolor" method="POST">
            <label>Foreground color:</label>
            <input type="text" name="foregroundC"/>
            <br><br>
            <label>Background color:</label>
            <input type="text" name="backgroundC"/>
            <br><br>
            <input type="submit" value="showcolor"/>
            
        </form>
    </body>
</html>
