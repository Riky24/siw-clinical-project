<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.uniroma3.modelli.Utente"%>

<% Utente utente = (Utente)session.getAttribute("utente");
//        if(utente==null) {
//    		request.setAttribute("loginError", "Devi effettuare il login");
//    		out.clear();
//    		RequestDispatcher rd = application.getRequestDispatcher("/effettuaLogin.jsp");
//           rd.forward(request, response);
//           return;
//        }
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
<title>Riepilogo dati</title>
</head>
<style>
body {
	background-color: #9999ff;
	color: #000000;
	text-align: center;
}

div.well {
	
	border: 30px solid #000080;
	position: well;
	font-size: 25px;
	font-weight: 700;
}
</style>
<body>
	<div class="well">
		<p>Username: ${utente.username};</p>
		<p>Password: ${utente.password};</p>
		<p>Nome: ${utente.nome};</p>
		<p>Cognome: ${utente.cognome};</p>
		<p>Codice Fiscale: ${utente.codiceFiscale};</p>
		<p>Ruolo: ${utente.ruolo};</p>
	</div>
	<div>
		<form action=inserisciTipologiaEsame.jsp>
			<input type="submit" value="inserisci una tipologia di esame"
				class="btn btn-lg btn-primary">
		</form>
	</div>
	<div>
		<form action=creaPrenotazione.jsp>
			<input type="submit" value="Prenota un esame"
				class="btn btn-lg btn-primary">
		</form>
	</div>
	<div>
		<form action="/siw-clinical-project/logoutcontroller" method="post">
			<button id="btnhome" type="submit" name="logout"
				class="btn btn-lg btn-danger" value="logout">Logout</button>

		</form>
	</div>
</body>
</html>