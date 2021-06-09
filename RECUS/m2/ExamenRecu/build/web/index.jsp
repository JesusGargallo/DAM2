<%-- 
    Document   : index
    Created on : 09-jun-2021, 17:17:39
    Author     : Raul
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
        int operand1, operand2, resultat;
        
         try{
             resultat = Integer.parseInt(String.valueOf(session.getAttribute("resultado")));
             operand1 = Integer.parseInt(String.valueOf(session.getAttribute("operand1")));
             operand2 = Integer.parseInt(String.valueOf(session.getAttribute("operand2")));
         
         }catch(Exception e){
             resultat = 0;
             operand1 = 0;
             operand2 = 0;
         }
        
        %>
        
  <form action="opera">

<label>Operador1:</label><br>

<input type="number" name="operand1" value=<%=operand1%>><br><br>

<input type="radio" name="operador" value="suma">

<label for="male">+</label><br>

<input type="radio" name="operador" value="resta">

<label for="female">-</label><br><br>

<label>Operador2:</label><br>

<input type="number" name="operand2" value=<%=operand2%>><br><br>

<input type="submit" value="="><br>

<br>

<label>Resultat:</label>

<%=resultat %>

</form>      
    </body>
</html>
