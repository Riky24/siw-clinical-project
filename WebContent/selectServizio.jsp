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
			value='${ param["servizio1"]}'>servizio1</button>

		<button type="submit" name="servizio2" class="btn btn-default"
			value='${ param["servizio2"]}'>servizio2</button>
			
		<button type="submit" name="servizio3" class="btn btn-default"
			value='${ param["servizio3"]}'>servizio3</button>
			
		<button type="submit" name="servizio4" class="btn btn-default"
			value='${ param["servizio4"]}'>servizio4</button>
	</form>
</body>
</html>