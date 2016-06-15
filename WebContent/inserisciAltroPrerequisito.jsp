<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="it.uniroma3.modelli.*"%>

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

<%
	TipologiaEsame tipologiaEsame = (TipologiaEsame) session.getAttribute("tip");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<title>Inserisci un altro prerequisito</title>
</head>
<style>
body {
    background-color: #9999ff;
        color: #000000;
    text-align: center;
}
div.form_container {
	position: form_container;
	font-size: 25px;
}
</style>
<body>

	<h2>Inserimento altri requisiti</h2>

	<div class="form_container">
<div class="col-md-4 col-md-offset-4">
		<form action="inserisciAltroPrerequisitoController" method="post">

			<div class="form-group">

				<p>${chiaveError}</p>

				<label>Chiave Prerequisito</label> <input type="text"
					class="form-control" placeholder="Chiave Prerequisito"
					name="chiavePrerequisito" value='${param["chiavePrerequisit"]}' />
			</div>

			<div class="form-group">

				<p>${valoreError}</p>

				<label>Valore Prerequisito</label> <input type="text"
					class="form-control" placeholder="Valore Prerequisito"
					name="valorePrerequisito" value='${param["valorePrerequisit"]}' />
			</div>
</div>
<p>${prerequisitoAggiunto}</p>

			<button type="submit" name="bt" value="salva" class="btn btn-lg btn-primary">Salva</button>
			<button type="submit" name="bt" value="inserisciAltroPrerequisito" class="btn btn-lg btn-primary">Aggiungi
				un altro prerequisito</button>

		</form>
		
			<form action=loginEffettuatoAmministratore.jsp>
		<input type="submit" value="Torna alla pagina utente" class="btn btn-lg btn-info">
	</form>
	</div>

</body>
</html>