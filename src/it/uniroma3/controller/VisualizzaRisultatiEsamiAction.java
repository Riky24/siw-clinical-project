package it.uniroma3.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.modelli.Facade;
import it.uniroma3.modelli.RisultatoEsame;
import it.uniroma3.modelli.TipologiaEsame;
import it.uniroma3.modelli.Utente;

public class VisualizzaRisultatiEsamiAction {

	public List<RisultatoEsame> execute(Utente utente){
		
		Facade facade = new Facade();
		facade.istanziaEntityManager();
//		List<RisultatoEsame> r = facade.trovaEsamiPaziente(utente.getId());
		List<RisultatoEsame> r = facade.getAllRisultatoEsame();
		return r;
	}
	
}
