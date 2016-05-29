<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="it.uniroma3.modelli.*"%>

<%
	TipologiaEsame tipologiaEsame = (TipologiaEsame) session.getAttribute("tip");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci un altro prerequisito</title>
</head>
<body>

	<h2>Inserimento altri requisiti</h2>

	<div class="form_container">

		<form action="inserisciAltroPrerequisitoController" method="post">

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
			<button type="submit" name="bt" value="inserisciAltroPrerequisito">Aggiungi
				un altro prerequisito</button>

		</form>
	</div>

</body>
</html>