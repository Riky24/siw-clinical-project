package it.uniroma3.controller;
import javax.servlet.http.HttpServletRequest;


import it.uniroma3.modelli.TipologiaEsame;
import it.uniroma3.modelli.Prerequisito;
import it.uniroma3.modelli.Facade;


public class InserisciTipologiaEsameAction {

	public String execute(HttpServletRequest request, TipologiaEsame tipologiaEsame){
		
		
		
		Prerequisito prerequisito = new Prerequisito(request.getParameter("chiavePrerequisito"), request.getParameter("valorePrerequisito"));
		
		tipologiaEsame.setCodice(request.getParameter("codice"));
		tipologiaEsame.setNome(request.getParameter("nome"));
		tipologiaEsame.setCosto(request.getParameter("costo"));
		tipologiaEsame.setDescrizione(request.getParameter("descrizione"));
		tipologiaEsame.addPrerequisito(prerequisito);
		
		
		Facade facade = new Facade();
		facade.istanziaEntityManager();
		facade.inserisciTipologia(tipologiaEsame);
		facade.closeEm();
		
		
		request.setAttribute("tipologiaEsame", tipologiaEsame);
		
		return "/inseritaTipologiaEsame.jsp";
	}
	
}
