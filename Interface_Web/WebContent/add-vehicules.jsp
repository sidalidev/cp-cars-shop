<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entities.*"%>
<%@ page import="interfaces.*"%>
<%@ page import="java.util.*"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<%
	List<TypeEntity> type2 = (List<TypeEntity>) request.getAttribute("type");
	System.out.println(type2);
%>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>Ajout d'un vehicule</title>
<link rel="stylesheet" href="assets/semantic-ui/semantic.min.css" />
</head>
<body>
	<div class="ui middle aligned center aligned grid"
		style="max-width: 500px; margin: auto;">
		<div class="column">
			<h2 class="ui teal image header">
				<!-- <img src="assets/images/logo.png" class="image" /> -->
				<div class="content">Ajout d'un vehicule</div>
			</h2>
			<form class="ui large form">
				<div class="ui stacked segment">
					<div class="field">
						<div class="ui left icon input">
							<i class="user icon"></i> <input name="name"
								placeholder="Nom du vehicule" type="text" />
						</div>
					</div>
					<div class="field">
						<div class="ui left icon input">
							<i class="lock icon"></i> <input type="number" name="quantity"
								placeholder="Quantité" />
						</div>
					</div>
					<div class="field">
						<div class="ui left icon input">
							<i class="lock icon"></i> <input type="number" step="0.01"
								name="price" placeholder="Prix" />
						</div>
					</div>
					<div class="field">
						<div class="ui left icon input">
							<i class="lock icon"></i> <input type="text" name="options"
								placeholder="Options" />
						</div>
					</div>
					<div class="field">
						<div class="ui left icon input">
							<i class="lock icon"></i> <input type="text" name="type"
								placeholder="Type" />
						</div>
					</div>
					<button class="ui fluid large teal submit button" type="submit">Inscription</button>
				</div>
			</form>
		</div>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script type="text/javascript" src="assets/semantic-ui/semantic.min.js"></script>
</html>