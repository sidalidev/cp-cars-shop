<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Login Page</title>
</head>
<body>
	<form action="User_Servlet" method="get">
		<input type="email" name="email" placeholder="user@fournisseur.fr"/>
		<input type="password" name="password" placeholder="*******" />
		<input type="submit" value="submit">
	</form>
</body>
</html>
