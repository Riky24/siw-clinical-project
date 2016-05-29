package it.uniroma3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InserisciAltroPrerequisitoHelper {

	public boolean validate(HttpServletRequest request, HttpServletResponse response) {

		boolean corretto = true;

		
		// accedo ai dati della form
		String chiave = request.getParameter("chiavePrerequisito");
		String valore = request.getParameter("valorePrerequisito");

		
		// verifico la correttezza dei dati immessi nella form.
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
