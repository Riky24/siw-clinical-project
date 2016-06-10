<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="it.uniroma3.modelli.*"%>

<%
	Utente utente = (Utente) session.getAttribute("utente");
	//        if(utente==null) {
	//    		request.setAttribute("loginError", "Devi effettuare il login");
	//    		out.clear();
	//    		RequestDispatcher rd = application.getRequestDispatcher("/effettuaLogin.jsp");
	//           rd.forward(request, response);
	//           return;
	//        }
	if (utente == null || utente.getRuolo().equals("user")) {
		if (utente.getRuolo().equals("user")) {
			request.setAttribute("loginError", "Devi effettuare il login come amministratore");
		} else
			request.setAttribute("loginError", "Devi effettuare il login");
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
<title>Inserimento tipologia esame</title>
</head>
<body>

	<div>
		<h2>Inserisci una nuova tipologia di esame</h2>
		<div>
			<div class="form_container">

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

					<button type="submit" name="bt" value="salva">Salva</button>
					<button type="submit" name="bt" value="inserisciAltriPrerequisiti">Aggiungi
						un altro prerequisito</button>

				</form>

<form action="/siw-clinical-project/logoutcontroller" method="post">
		<button type="submit" name="logout" class="btn btn-default"
			value="logout">Logout</button>
	</form>

			</div>
		</div>
	</div>
</body>
</html>