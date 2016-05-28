<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.uniroma3.modelli.TipologiaEsame"%>
<%@ page import="it.uniroma3.modelli.Prerequisito"%>
<%-- <%@  page import="javax.persistence.EntityManager"%> --%>
<%-- <%@ page import="javax.persistence.EntityManagerFactory"%> --%>
<%-- <%@ page import="javax.persistence.Persistence"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Esami offerti dalla clinica</title>
</head>
<body>

	<h1>Tipologie di esami offerti dalla clinica</h1>

	<form action="tipologieEsamiOffertiController" method="get">
		<input type="hidden" name="tipologiaEsame" value="vista">
		<button type="submit" name="vista" class="btn btn-default"
			value='${ param["vista"]}'>Esame della vista</button>
	</form>

	<form action="tipologieEsamiOffertiController" method="get">
		<input type="hidden" name="tipologiaEsame" value="sangue">
		<button type="submit" name="sangue" class="btn btn-default"
			value='${ param["sangue"]}'>Esame del sangue</button>
	</form>

</body>
</html>