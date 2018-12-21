<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="entities.*" %> 
<%@ page import="interfaces.*" %>
<%@ page import="java.util.*"%>




<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <% 
	List<TypeEntity> type2 = (List<TypeEntity>) request.getAttribute("type");
	System.out.println(type2);
    
    %>
    
 </head>
 <body>


 
 <form action="Vehicule_Servlet" method="post">
	
		<input type="text" name="name" placeholder="Type"><br>
		<input type="number" name="quantity" placeholder="Qunatity"><br>
		<input type="number" step="0.01" name="price" placeholder=""><br>
		<input type="text" name="options" placeholder="Options"><br>
		<input type="text" name="type" placeholder="Type"><br>
		<button type="submit">Inscription</button>
	

	</form>
 
 
 </body>
 </html>