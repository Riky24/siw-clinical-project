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
			
				<form action="inserisciTipologiaEsameController" method="post">

					<div class="form-group">

						<p>${nomeError}</p>

						<label>Nome</label> <input type="text" class="form-control"
							placeholder="Nome" name="nome" value='${param["nome"]}' />
					</div>

					<div class="form-group">

						<p>${codiceError}</p>

						<label>Codice</label> <input type="text" class="form-control"
							placeholder="Codice" name="codice" value='${param["codice"]}' />
					</div>

					<div class="form-group">

						<p>${costoError}</p>

						<label>Costo</label> <input type="text" class="form-control"
							placeholder="Costo" name="costo" value='${param["costo"]}' />
					</div>

					<div class="form-group">

						<p>${descrizioneError}</p>

						<label>Descrizione</label> <input type="text" class="form-control"
							placeholder="Descrizione" name="descrizione"
							value='${param["descrizione"]}' />
					</div>

					<div class="form-group">

						<p>${chiaveError}</p>

						<label>Chiave Prerequisito</label> <input type="text"
							class="form-control" placeholder="Chiave Prerequisito" name="chiavePrerequisito"
							value='${param["chiavePrerequisito"]}' />
					</div>

					<div class="form-group">

						<p>${valoreError}</p>

						<label>Valore Prerequisito</label> <input type="text"
							class="form-control" placeholder="Valore Prerequisito" name="valorePrerequisito"
							value='${param["valorePrerequisito"]}' />
					</div>

					<button type="submit" class="btn btn-default">Invia</button>
					
				</form>
				
				
				
			</div>
		</div>
	</div>
</body>
</html>