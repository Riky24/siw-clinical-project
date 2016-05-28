<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.uniroma3.modelli.TipologiaEsame"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dati del servizio</title>
</head>
<body>
	<p>Nome: ${servizio.nome};</p>
	<p>Descrizione: ${servizio.descrizione};</p>
	<p>Costo: ${servizio.costo};</p>
	<p>Prerequisiti: ${servizio.prerequisiti};</p>
	<form action=selectServizio.jsp>
		<input type="submit" value="back">
	</form>
</body>
</html>