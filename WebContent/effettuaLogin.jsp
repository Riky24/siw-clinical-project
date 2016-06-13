<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<title>Login</title>
</head>
<style>
body {
    background-color: lightgreen;
    color: #000000;
    text-align: center;
    font-size: 30px;
}
</style>
<body>
	<form action="logincontroller" method="post">

		<p>${usernameError}</p>
		UserName: <input type="text" name="username"
			value='${param["username"]}' />

		<p>${passwordError}</p>
		Password: <input type="password" name="password"
			value='${param["password"]}' />

		<p>${loginError}</p>
<div class="col-md-4 col-md-offset-4">
		<button type="submit" name="login" class="btn btn-lg btn-primary"
			value="login">Login</button>
			</div>
	</form>
		<form action=paginaIniziale.jsp>
		<input type="submit" value="indietro" class="btn btn-lg btn-info">
	</form>
<!-- 	<p>Amministratore: user - mario, password - rossi</p> -->
<!-- 	<p>Paziente Registrato: user - stefano, password - bianchi</p> -->
</body>
</html>