<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.uniroma3.modelli.Facade" %>
<%@ page import="it.uniroma3.modelli.TipologiaEsame" %>
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
<title>Prenotazione</title>
</head>
<style>
body {
    background-color: #9999ff;
            color: #000000;
    text-align: center;
}
</style>
<body>
	<form name="prenota" action="prenotazioneController" method="post">
	<p>${pazienteError}</p>
		Codice Fiscale del paziente<input type="text" name="codFis" value='${param["codFis"]}'>
	<p>codice fiscale = codice+Nome</p>
	<input type="hidden" name="string" value='${string}'>
	<div>
	<script type="text/javascript">
	var str = document.forms.prenota.string.value;
	document.write(str);
	</script>
	<!-- <script type="text/javascript">
	var tip = document.forms.prenota.tesam.value;
	document.write('<input type=\"hidden\" name=\"tip\" value=\"'+tip+'\">');
	</script> -->
	<input type="hidden" name="tipologia" value='${param["tipologia"]}'>
	</div>
    <input type="submit" name="prenota" value="Prenota">
	</form>
</body>
</html>