<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entities.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Options</title>




<%
	List<CartEntity> cart = (List<CartEntity>) request.getAttribute("cart");
	
%>
</head>
<body>

<h2>Voir les commandes du site</h2>

<table>

<tr>
	<th>Nom de la personne </th>
	<th>Statut de la commande </th>
	<th>Produit commande </th>
<tr>		
	<%
		for (int i = 0; i < cart.size(); i++) {
	%>

<tr>
		<th><%=cart.get(i).getUser().getEmail()%></th>


		<th><%=cart.get(i).getEnCours()%></th>
		
		<th>
		<%
		String test = new String();
		List<VehiculesEntity> vehicule = cart.get(i).getVehicules();
		for (int j = 0; j < vehicule.size(); j++) {
		%>
		
			<% test=vehicule.get(j).getName()+","; 
			System.out.println(test);%>
			
	<%
		}
	%>
		<%= test %>
		<th>
</tr>
<%
	}
%>
</table>

</body>
</html>