<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="it.uniroma3.modelli.*"%>
    <%@ page import="java.util.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<title>Dettagli tipologia</title>
</head>
<style>
body {
    background-color: lightgreen;
        color: #000000;
    text-align: center;
}
div.well {
	position: well;
	font-size: 25px;
}
h2 {
	font-size: 35px;
}
</style>
<body>

<h2 align="center">Requisiti dell'esame selezionato:<span></span></h2>

	<%
	TipologiaEsame p = (TipologiaEsame) request.getAttribute("prerequisitoo");
	%>

<div class="well" id="ff" align="center">
	<b><%=p.getDescrizione()%></b>

			<%
				for (Prerequisito indi : p.getListPrerequisiti()) {
			%>

<li><%=indi.getValore()%></li>


				<%
 					}
 				%>
	<form action=elencoTipologieEsami.jsp>
		<input type="submit" value="Indietro" class="btn btn-lg btn-info">
			</form>
	</div>

</body>
</html>