<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<title>Pagina Iniziale</title>
</head>
<style>
body {
    background-color: lightgreen;
}
.jumbotron {
    color: #000099;
}
</style>

<body>

<div id="exform" class="container-fluid ex">
<div class="jumbotron">
	<h1 class="text-center">BENVENUTO NELLA CLINICA R.S.L.</h1>
	<p>Premi 'Effettua login' per andare alla pagina di autenticazione. Solo
	gli amministratori e i pazienti registrati possono effettuare l'accesso</p>
	</div>
<div class="col-md-4 col-md-offset-4">

	<form action="paginaInizialeController" method=post>
	
		<button type="submit" name="bt" value="Effettua login" class="btn btn-lg btn-primary">Effettua
			login</button>
	</form>

	<form action="visualizzaTipologieEsamiController" method=post>
	
		<button type="submit" name="bt" value="Visualizza esami" class="btn btn-lg btn-primary">Esami offerti</button>
	</form>

</div>
</div>
</body>
</html>