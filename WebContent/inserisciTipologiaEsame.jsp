<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserimento tipologia esame</title>
</head>
<body>

	<div>
		<h2>Inserimento di una nuova tipologia di esame</h2>
		<div>
			<div class="form_container">
				<form action="esamiofferticontroller" method="post">
				
					<div class="form-group">
						<label>Nome</label> <input type="text" class="form-control"
							placeholder="Nome" name="nome" value='${param["nome"]}' />
					</div>

					<div class="form-group">
						<label>Codice</label> <input type="text" class="form-control"
							placeholder="Codice" name="codice" value='${param["codice"]}' />
					</div>

					<div class="form-group">
						<label>Costo</label> <input type="text" class="form-control"
							placeholder="Costo" name="costo" value='${param["costo"]}' />
					</div>

					<div class="form-group">
						<label>Descrizione</label> <input type="text" class="form-control"
							placeholder="Descrizione" name="descrizione" value='${param["descrizione"]}' />
					</div>
					
					</body>
</html>