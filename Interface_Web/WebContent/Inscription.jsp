<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>

<body>

	<form action="User_Servlet" method="post">
	
		<input type="text" name="username" placeholder="Nom d'utilisateur"><br>
		<input type="email" name="email" placeholder="utilisateur@fournisseur.fr"><br>
		<input type="password" name="password" placeholder="*******"><br>
		<button type="submit">Inscription</button>
	
	</form>
	
</body>
</html>