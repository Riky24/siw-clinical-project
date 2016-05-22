<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettagli esame</title>
</head>
<body>

	<p>Nome: ${tipologiaEsame.nome};</p>
	<p>Codice: ${tipologiaEsame.codice};</p>
	<p>Descrizione: ${tipologiaEsame.descrizione};</p>
	<p>Costo: ${tipologiaEsame.costo};</p>
<!-- 	come faccio a rappresentare i requisiti? -->
	<p>Requisiti: ${tipologiaEsame.prerequisiti};</p>

	<form action=tipologieEsami.jsp>
		<input type="submit" value="back">
	</form>

</body>
</html>