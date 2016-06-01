<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.uniroma3.modelli.TipologiaEsame"%>
<%@ page import="it.uniroma3.modelli.Utente"%>
<%
	Utente utente = (Utente) session.getAttribute("utente");
	if (utente == null || utente.getRuolo().equals("admin")) {
		if (utente.getRuolo().equals("admin")) {
			request.setAttribute("loginError", "Effettua il login come paziente");
		} else
			request.setAttribute("loginError", "Effettua il login");
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
<title>Dati del servizio</title>
</head>
<body>
	<p>Esame: ${DettagliEsamePaziente.nome};</p>
	<p>Descrizione: ${DettagliEsamePaziente.descrizione};</p>
	<p>Effettuato il: ${DettagliEsamePaziente.fatto};</p>
	<form action=ElencoEsamiPaziente.jsp>
		<input type="submit" value="back">
	</form>
</body>
</html>