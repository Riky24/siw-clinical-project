<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="it.uniroma3.modelli.Utente" %>
    
        <% Utente utente = (Utente)session.getAttribute("utente");
//        if(utente==null) {
//    		request.setAttribute("loginError", "Devi effettuare il login");
//    		out.clear();
//    		RequestDispatcher rd = application.getRequestDispatcher("/effettuaLogin.jsp");
//           rd.forward(request, response);
//           return;
//        }
    	if (utente == null || utente.getRuolo().equals("admin")) {
    		if (utente == null) {
    			request.setAttribute("loginError", "Devi effettuare il login");
    		} else
    			request.setAttribute("loginError", "Devi effettuare il login come paziente");
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
<title>Riepilogo dati</title>
</head>
<body>
<p>Username: ${utente.username};</p>
<p>Password: ${utente.password};</p>
<p>Nome: ${utente.nome};</p>
<p>Cognome: ${utente.cognome};</p>
<p>Codice Fiscale: ${utente.codiceFiscale};</p>
<p>Ruolo: ${utente.ruolo};</p>

<form action=visualizzaRisultatiEsamiController method="post">
		<input type="submit" value="Visualizza i risultati dei tuoi esami">
	</form>

<form action="/siw-clinical-project/logoutcontroller" method="post">
		<button type="submit" name="logout" class="btn btn-default"
			value="logout">Logout</button>
	</form>
</body>
</html>