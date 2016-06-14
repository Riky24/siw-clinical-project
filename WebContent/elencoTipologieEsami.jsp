<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.util.*"%>
<%@ page import="it.uniroma3.modelli.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<style>
body {
    background-color: lightgreen;
        color: #000000;
    text-align: center;
}
</style>
<body>

<h2>Queste sono le tipologie di esami che offriamo</h2>

	<%
		List<TipologiaEsame> r = (ArrayList<TipologiaEsame>) session.getAttribute("tipologie");
	%>

			<%
				for (TipologiaEsame ris : r) {
			%>


<li>Nome: <b><%=ris.getDescrizione()%></b>
					<form action="dettagliTipologiaEsameController" method="post">
						<button type="submit" name="nomeTip" class="btn btn-lg btn-primary" 
						value="<%=ris.getId()%>">Visualizza dettagli</button>
					</form></li>


				<%
 					}
 				%>


 							<form action=paginaIniziale.jsp>
		<input type="submit" value="Torna indietro" class="btn btn-lg btn-info">
	</form>
</body>
</html>