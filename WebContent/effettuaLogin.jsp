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
		Password: <input type="text" name="password"
			value='${param["password"]}' />

		<p>${loginError}</p>

		<button type="submit" name="login" class="btn btn-default"
			value="login">Login</button>
	</form>
	<p>Amministratore: user - mario, password - rossi</p>
	<p>Utente Registrato: user - rossi, password - mario</p>
</body>
</html>