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
<li><a href="/Interface_Web/Vehicule_Servlet?method=getAll">Voir vehicule</a></li>
<% } else { %>

<% if(user.getRole()==1){ %>
<li><a href="/Interface_Web/add-vehicules.jsp">Add Vehicules</a></li>
<li><a href="/Interface_Web/Vehicule_Servlet?id=7">Voir le vehicule</a></li>
<li><a href="/Interface_Web/view-option">Voir les options</a></li>
<li><a href="/Interface_Web/view-type">Voir les options</a></li>
<li><a href="/Interface_Web/Cart_Servlet?method=getAll">Voir toutes les commandes</a></li>
<%} %>

<li><a href="/Interface_Web/CreateUser.jsp">Deconnexion</a></li>
<li><a href="">Mon compte</a></li>
<%} %>
</ul>
</header>

<content>

	<div> Bienvenue sur le magasin d'ecommerce </div>
	
	<li><a href="/Interface_Web/Vehicule_Servlet?method=getAll">Voir tous les vehicule</a></li>
	
</content>

</body>
</html>