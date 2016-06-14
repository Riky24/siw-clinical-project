<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="it.uniroma3.modelli.*"%>
    <%@ page import="java.util.*"%>
    
            <% Utente utente = (Utente)session.getAttribute("utente");
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
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<title>Dettagli risultato</title>
</head>
<style>
body {
    background-color: lightgreen;
        color: #000000;
    text-align: center;
}
div.well {
	position: well;
	font-size: 25px;
}
h2 {
	
	font-size: 35px;
}
</style>
<body>

<h2 align="center">Dettagli sull'esame selezionato<span></span></h2>

	<%
	RisultatoEsame p = (RisultatoEsame) request.getAttribute("risultatoo");
	%>

<div class="well" id="ff" align="center">
	<b><%=p.getNome()%></b>

			<%
				for (Indicatore indi : p.getIndicatori()) {
			%>
<tr>
<li>Nome: <b><%=indi.getNome()%></b>
&nbsp;&nbsp;Valore: <b><%=indi.getValore()%></b></li>
</tr>

				<%
 					}
 				%>
	<form action=risultatiEsamiPaziente.jsp>
		<input type="submit" value="Indietro" class="btn btn-lg btn-info">
			</form>
	</div>

</body>
</html>