<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina Personale</title>
</head>
<body>
	<Intestazione>Consulta i propri esami effettuati</Intestazione>
	<form action="controllerServizio" method="get">
		<input type="hidden" name="esame" value="esame">
		<button type="submit" name="esame1" class="btn btn-default"
			value='${ param["servizio"]}'>esame1</button>
	</form>
</body>
</html>