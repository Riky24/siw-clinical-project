package it.uniroma3.controller;

import javax.servlet.http.HttpServletRequest;

public class InserisciTipologiaEsameHelper {

	
	public boolean validate(HttpServletRequest request) {
		
		boolean corretto = true;
		
		// accedo ai dati della form
		String codice = request.getParameter("codice");
		String nome = request.getParameter("nome");
		String costo = request.getParameter("costo");
		String descrizione = request.getParameter("descrizione");
		
		String chiave = request.getParameter("chiavePrerequisito");
		String valore = request.getParameter("valorePrerequisito");
		
		// verifico la correttezza dei dati immessi nella form.
		if(codice.equals("")){
			request.setAttribute("codiceError", "Codice: Campo Obbligatorio");
			corretto = false;
		}

		if(nome.equals("")){
			request.setAttribute("nomeError", "Nome: Campo Obbligatorio");
			corretto = false;
		}

		if(costo.equals("")){
			request.setAttribute("costoError", "Costo: Campo Obbligatorio");
			corretto = false;
		}
		
		if(descrizione.equals("")){
			request.setAttribute("descrizioneError", "Descrizione: Campo Obbligatorio");
			corretto = false;
		}
		
		if(chiave.equals("")){
			request.setAttribute("chiaveError", "Chiave Prerequisito: Campo Obbligatorio");
			corretto = false;
		}
		
		if(valore.equals("")){
			request.setAttribute("valoreError", "Valore Prerequisito: Campo Obbligatorio");
			corretto = false;
		}
		
		return corretto;
	}
}
