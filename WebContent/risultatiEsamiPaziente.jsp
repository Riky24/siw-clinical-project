<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.*"%>
<%@ page import="it.uniroma3.modelli.*"%>
    
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
<title>Risultati</title>
</head>
<style>
body {
    background-color: lightgreen;
        color: #000000;
    text-align: center;
}
li {
    background-color: lightgreen;
font-size: 25px;
}
</style>
<body>

<h2>Ecco i tuoi risultati</h2>

	<%
		List<RisultatoEsame> r = (ArrayList<RisultatoEsame>) session.getAttribute("risultati");
	%>



			<%
				for (RisultatoEsame ris : r) {
			%>


<li><b><%=ris.getNome()%></b>
					<form action="dettagliRisultatoEsameController" method="post">
						<button type="submit" name="nomeRis" class="btn btn-lg btn-primary" 
						value="<%=ris.getId()%>">Visualizza dettagli</button>
					</form></li>


				<%
 					}
 				%>
 				
 							<form action=loginEffettuatoPaziente.jsp>
		<input type="submit" value="Torna alla pagina utente" class="btn btn-lg btn-info">
	</form>
</body>
</html>