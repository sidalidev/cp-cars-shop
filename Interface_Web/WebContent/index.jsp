<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entities.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
<%
	UserEntity user = (UserEntity)request.getSession(false).getAttribute("currentSessionUser");
%>
</head>

<body>

<header>

<ul>
<li>Mon Compte</li>
<% if(user==null){ %>
<li><a href="/Interface_Web/CreateUser.jsp">Creation compte</a></li>
<li><a href="/Interface_Web/Login.jsp">Se connecter</a></li>
<li><a href="/Interface_Web/add-vehicules.jsp">Add Vehicules</a></li>
<li><a href="/Interface_Web/Vehicule_Servlet?method=getAll">Voir vehicule</a></li>
<li><a href="/Interface_Web/Vehicule_Servlet?id=7">Voir le vehicule</a></li>
<li><a href="/Interface_Web/Cart_Servlet?method=getAll">Voir toutes les commandes</a></li>
<% } else { %>
<li><a href="/Interface_Web/CreateUser.jsp">Add vehicule</a></li>
<%} %>
</ul>
</header>



<form action="Options_Servlet" method="get">
								<button type="submit" class="btn btn-primary">Accéder
									aux options</button>
</form>

<form action="Type_Servlet" method="get">
								<button type="submit" class="btn btn-primary">Accéder
									aux types</button>
</form>

<form action="Type_Servlet" method="get">
								<button type="submit" class="btn btn-primary">Accéder
									aux types</button>
</form>
	


</body>
</html>