<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="logincontroller" method="post">
		<p>${usernameError}</p>
		UserName: <input type="text" name="username"
			value='${param["username"]}' />

		<p>${passwordError}</p>
		Password: <input type="password" name="password"
			value='${param["password"]}' />

		<p>${loginError}</p>

		<button type="submit" name="login" class="btn btn-default"
			value="login">Login</button>
	</form>
		<form action=paginaIniziale.jsp>
		<input type="submit" value="indietro">
	</form>
	<p>Amministratore: user - mario, password - rossi</p>
	<p>Paziente Registrato: user - stefano, password - bianchi</p>
</body>
</html>