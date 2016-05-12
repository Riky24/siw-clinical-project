<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Selezione servizio</title>
</head>
<body>
	<Intestazione>Sevizi offerti dalla clinica</Intestazione>
	<form action="controllerServizio" method="get">
		<button type="submit" name="servizio1" class="btn btn-default"
			value=></button>

		<button type="submit" name="servizio2" class="btn btn-default"
			value='${ param["servizio"]}'>servizio2</button>
	</form>
</body>
</html>