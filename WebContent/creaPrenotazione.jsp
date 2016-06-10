<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.uniroma3.modelli.Facade" %>
<%@ page import="it.uniroma3.modelli.TipologiaEsame" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prenotazione</title>
</head>
<body>
	<form action="prenotazioneController" method="post">
	<p>${pazienteError}</p>
		Codice Fiscale del paziente<input type="text" name="codFis" value='${param["codFis"]}'>
	<p>codice fiscale = codice+Nome</p>
	<p>${tipologiaError}</p>
	<div>
	<script type="text/javascript">
	document.write("<select id=\"tesam\" name=\"tesam\">");
	var f = Java.type("it.uniroma3.modelli.Facade");
	f.istanziaEntityManager();
	var list = f.getTipologieEsami();
	for (var x in list){
		document.write('<option value="'+x.getId()+'">'+x.getNome()+'</option>');
	}
	document.write("</select>");
	</script>
	</div>
	<input type="hidden" name="prova" value='${param["tipologia"]}'>
	<input type="submit" name="ok" value="Prenota">
	</form>
</body>
</html>