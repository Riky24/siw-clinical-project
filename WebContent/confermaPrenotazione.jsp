<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="it.uniroma3.modelli.Utente" %>
<% Utente utente = (Utente)session.getAttribute("utente");
    	if (utente == null || utente.getRuolo().equals("user")) {
    		if (utente == null) {
    			request.setAttribute("loginError", "Devi effettuare il login");
    		} else
    			request.setAttribute("loginError", "Devi effettuare il login come amministratore");
    		out.clear();
    		RequestDispatcher rd = application.getRequestDispatcher("/effettuaLogin.jsp");
    		rd.forward(request, response);
    		return;
    	}
     %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<title>Conferma Prenotazione</title>
</head>
<style>
body {
    background-color: #9999ff;
            color: #000000;
    text-align: center;
}
</style>
<body>
	Prenotazione effettuata con successo!
	<form action="loginEffettuatoAmministratore.jsp">
		<button type="submit" name="continua" class="btn btn-lg btn-primary"
			value="continua">Prosegui</button>
	</form>
</body>
</html>