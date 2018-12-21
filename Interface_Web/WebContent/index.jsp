<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entities.*"%>
<!DOCTYPE html>
<html>
<head>
<%
	UserEntity user = (UserEntity) request.getSession(false).getAttribute("currentSessionUser");
%>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>Accueil</title>
<link rel="stylesheet" href="assets/semantic-ui/semantic.min.css" />
</head>

<body>
	<div class="ui vertical left visible sidebar menu">
		<%
			if (user == null) {
		%>
		<a class="item" href="/Interface_Web/CreateUser.jsp"><i
			class="home icon"></i>Creation compte</a> <a class="item"
			href="/Interface_Web/Login.jsp"><i class="home icon"></i>Se
			connecter</a> <a class="item"
			href="/Interface_Web/Vehicule_Servlet?method=getAll"><i
			class="home icon"></i>Voir vehicule</a>
		<%
			} else {
		%>

		<%
			if (user.getRole() == 1) {
		%>
		<a class="item" href="/Interface_Web/add-vehicules.jsp"><i
			class="home icon"></i>Add Vehicules</a> <a class="item"
			href="/Interface_Web/Vehicule_Servlet?id=7"><i class="home icon"></i>Voir
			le vehicule</a> <a class="item" href="/Interface_Web/view-option"><i
			class="home icon"></i>Voir les options</a> <a class="item"
			href="/Interface_Web/view-type"><i class="home icon"></i>Voir les
			options</a> <a class="item"
			href="/Interface_Web/Cart_Servlet?method=getAll"><i
			class="home icon"></i>Voir toutes les commandes</a>
		<%
			}
		%>

		<a class="item" href=""><i class="home icon"></i>Mon compte</a> <a
			class="item" href="/Interface_Web/User_Servlet?method=logout">Deconnexion</a>
		<%
			}
		%>
	</div>
	<div class="pusher" style="padding: 1em;">
		<h1>Bienvenue sur le magasin d'ecommerce</h1>
		<a href="/Interface_Web/Vehicule_Servlet?method=getAll">Voir tous
			les vehicule</a>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script type="text/javascript" src="assets/semantic-ui/semantic.min.js"></script>
</html>