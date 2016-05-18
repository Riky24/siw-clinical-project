<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="it.uniroma3.modelli.Utente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Riepilogo dati</title>
</head>
<body>
Username: ${utente.username};
Password: ${utente.password};
Ruolo: ${utente.ruolo};

<form action="/siw-clinical-project/logoutcontroller" method="get">
		<button type="submit" name="logout" class="btn btn-default"
			value="logout">Logout</button>
	</form>
</body>
</html>