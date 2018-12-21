<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>Création d'un utilisateur</title>
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
			<form class="ui large form" action="Users_Servlet" method="post">
				<div class="ui stacked segment">
					<div class="field">
						<div class="ui left icon input">
							<i class="user icon"></i> <input type="email" name="email"
								placeholder="Email" />
						</div>
					</div>
					<div class="field">
						<div class="ui left icon input">
							<i class="lock icon"></i> <input type="password" name="password"
								placeholder="Mot de passe" />
						</div>
					</div>
					<button class="ui fluid large teal submit button" type="submit">S'inscrire</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>