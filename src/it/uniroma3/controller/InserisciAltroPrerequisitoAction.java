package it.uniroma3.controller;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.modelli.Facade;
import it.uniroma3.modelli.Prerequisito;
import it.uniroma3.modelli.TipologiaEsame;

public class InserisciAltroPrerequisitoAction {

	public String execute(HttpServletRequest request, TipologiaEsame tipologiaEsame){

		Prerequisito prerequisito = new Prerequisito(request.getParameter("chiavePrerequisito"), request.getParameter("valorePrerequisito"));
		
		tipologiaEsame.addPrerequisito(prerequisito);
		
		Facade facade = new Facade();
		facade.istanziaEntityManager();
		facade.inserisciTipologia(tipologiaEsame);
		
		
		request.setAttribute("tipologiaEsame", tipologiaEsame);
		
		return "/inseritaTipologiaEsame.jsp";
	}
	
}
