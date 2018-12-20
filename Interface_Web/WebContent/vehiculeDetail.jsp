<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="entities.*" %> 

<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
      integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
    <link rel="stylesheet" href="css/index.css" />
<title>Détails</title>
<% User_entity user = (User_entity)request.getSession(false).getAttribute("currentSessionUser");%>
</head>
	<header
		class="navbar navbar-expand flex-column flex-md-row bd-navbar header">
		<div class="navbar-nav-scroll">
			<ul class="navbar-nav bd-navbar-nav flex-row">
				<li class="nav-item"><a class="nav-item nav-link mr-md-4"
					href="/Interface_Web/">Accueil</a></li>
				<li class="nav-item"><a class="nav-item nav-link mr-md-4"
					href="/Interface_Web/Voiture_Servlet">Voitures</a></li>
				<li class="nav-item"><a class="nav-item nav-link mr-md-4"
					href="/Interface_Web/Moto_Servlet">Motos</a></li>
				<li class="nav-item"><a class="nav-item nav-link mr-md-4"
					href="/Interface_Web/Autre_Servlet">Autres</a></li>
			</ul>
		</div>
		
		<ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
			<% if(user == null) { %>
				<li class="nav-item"><a class="nav-item nav-link mr-md-4"
					href="/Interface_Web/Login.jsp">Connexion</a></li>
				<li class="nav-item"><a class="nav-item nav-link mr-md-4"
					href="/Interface_Web/Inscription.jsp">Inscription</a></li>
			<% } else { %>
				<li class="nav-item"><a class="nav-item nav-link mr-md-4"
					href="/Interface_Web/User_Servlet?method=logout">Deconnexion</a></li>
			<% } %>		
		</ul>
	</header>
<body>
	<% Vehicule_entity ve = (Vehicule_entity)request.getAttribute("vehicule"); %>

	<div class="container">
		<div class="jumbotron">
    		<h1 id="articles">Détails de l'article proposé : </h1> 
		</div>

    <div class="card">
      <div class="card-body">
        <h5 class="card-title"><%= ve.getMarque() %></h5>
        <p class="card-text"><%= ve.getModele() %></p>
      </div>
      <ul class="list-group list-group-flush">
        <li class="list-group-item"><p>Description du produit : </p><p><%= ve.getDescription() %></p></li>
        <li class="list-group-item">Prix : <%= ve.getPrix() %> €</li>

        <% if(ve.getOptions().size() != 0){%>
        <li class="list-group-item">Options : <ul><% for(Option o : ve.getOptions()){%>
          <li><%= o.getName() %></li> <%}
        %></ul>
        </li>
        <%}%>

      </ul>
      <div class="card-body">
        <a href="index.html" class="card-link">Retour à l'accueil</a>
        <a href="#" class="card-link">Mettre dans le panier</a>
      </div>
    </div>
	</div>

</body>
</html>