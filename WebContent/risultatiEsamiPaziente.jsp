<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.*"%>
<%@ page import="it.uniroma3.modelli.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Risultati</title>
</head>
<body>

<h2>Ecco i tuoi risultati</h2>

	<%
		List<RisultatoEsame> r = (ArrayList<RisultatoEsame>) session.getAttribute("risultati");
	%>



			<%
// 				for (RisultatoEsame ris : r) {
			%>

<!-- 					<form action="infoProdotto.do" method="post"> -->
<!-- 						<button type="submit" name="Nome" -->
<%-- 							value="<%=risultatoEsame.getNome()%>">Visualizza</button> --%>
<!-- 					</form> -->

<%-- <li>Nome: <b><%=ris.getNome()%></b></li> --%>

				<%
//  					}
 				%>
</body>
</html>