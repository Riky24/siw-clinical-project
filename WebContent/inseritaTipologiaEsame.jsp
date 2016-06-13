<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="it.uniroma3.modelli.*"%>
    
            <%
                	Utente utente = (Utente)session.getAttribute("utente");
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
<title>Tipologia di esame</title>
</head>
<style>
body {
    background-color: lightgreen;
        color: #000000;
    text-align: center;
}
</style>
<body>

	<h1>Dati inseriti della tipologia di esame</h1>
	<ul>
		<li>Codice: <b>${tipologiaEsame.codice}</b></li>
		<!-- accedo alla chiave etichettata (nella sessione) come "studente" e invoco su quell'oggetto il metodo getMatricola() -->
		<li>Nome: <b>${tipologiaEsame.nome}</b></li>
		<!-- qui non ho cambiato nulla passando da request a sessione poichè automaticamente cerca i dati in entrambi -->
		<li>Costo: <b>${tipologiaEsame.costo}</b></li>
		<li>Descrizione: <b>${tipologiaEsame.descrizione}</b></li>
	</ul>

	<form action=inserisciTipologiaEsame.jsp>
		<input type="submit" value="Indietro" class="btn btn-lg btn-info">
	</form>
</body>
</html>