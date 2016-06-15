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
<title>Inserimento tipologia esame</title>
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

	<div>
		<h2>Inserisci una nuova tipologia di esame</h2>
		<div>
			<div class="form_container">
<div class="col-md-4 col-md-offset-4">
				<form action="inserisciTipologiaEsameController" method="post">

					<div class="form-group">

						<p>${nomeError}</p>

						<label>Nome</label> <input type="text" class="form-control"
							placeholder="Nome" name="nome" value='${param["nome"]}' />
					</div>

					<div class="form-group">

						<p>${codiceError}</p>

						<label>Codice</label> <input type="text" class="form-control"
							placeholder="Codice" name="codice" value='${param["codice"]}' />
					</div>

					<div class="form-group">

						<p>${costoError}</p>

						<label>Costo</label> <input type="text" class="form-control"
							placeholder="Costo" name="costo" value='${param["costo"]}' />
					</div>

					<div class="form-group">

						<p>${descrizioneError}</p>

						<label>Descrizione</label> <input type="text" class="form-control"
							placeholder="Descrizione" name="descrizione"
							value='${param["descrizione"]}' />
					</div>

					<div class="form-group">

						<p>${chiaveError}</p>

						<label>Chiave Prerequisito</label> <input type="text"
							class="form-control" placeholder="Chiave Prerequisito"
							name="chiavePrerequisito" value='${param["chiavePrerequisito"]}' />
					</div>

					<div class="form-group">

						<p>${valoreError}</p>

						<label>Valore Prerequisito</label> <input type="text"
							class="form-control" placeholder="Valore Prerequisito"
							name="valorePrerequisito" value='${param["valorePrerequisito"]}' />
					</div>
</div>
					<button type="submit" name="bt" value="salva" class="btn btn-lg btn-primary">Salva</button>
					<button type="submit" name="bt" value="inserisciAltriPrerequisiti" class="btn btn-lg btn-primary">Aggiungi
						un altro prerequisito</button>

				</form>

	<form action=loginEffettuatoAmministratore.jsp>
		<input type="submit" value="Torna alla pagina utente" class="btn btn-lg btn-info">
	</form>

			</div>
		</div>
	</div>
</body>
</html>