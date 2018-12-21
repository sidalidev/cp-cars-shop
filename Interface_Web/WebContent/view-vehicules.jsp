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
	List<VehiculesEntity> vehicule = (List<VehiculesEntity>) request.getAttribute("vehicule");
	
%>
</head>
<body>

<h2>Voir les vehicules ajoutes</h2>

<table>

<tr>
	<th>Nom du vehicule </th>
	<th>Prix du vehicule </th>
	<th>Quantite </th>
	<th>Type du vehicule </th>
	<th>Options du vehicule </th>
	<th> Details </th>
	
<tr>		
	<%
		for (int i = 0; i < vehicule.size(); i++) {
	%>

<tr>
		<th><%=vehicule.get(i).getName()%></th>


		<th><%=vehicule.get(i).getPrice()%></th>
		
		<th><%=vehicule.get(i).getQuantity()%></th>
		
		<th><%=vehicule.get(i).getType().getName()%></th>
		
		<th>
		<%
		String test = new String();
		List<OptionsEntity> options = vehicule.get(i).getOption();
		for (int j = 0; j < options.size(); j++) {
		%>
		
			<% test=options.get(j).getName()+","; 
			System.out.println(test);%>
			
	<%
		}
	%>
		<%= test %>
		<th>
		<%
		
		String url = new String();
		url = "/Interface_Web/Vehicule_Servlet?id="+vehicule.get(i).getId();
		%>
		<li><a href=<%= url %>>Details</a></li>
		<th>
</tr>
<%
	}
%>
</table>

</body>
</html>