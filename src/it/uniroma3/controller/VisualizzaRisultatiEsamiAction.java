package it.uniroma3.controller;

import java.util.ArrayList;
import java.util.List;



import it.uniroma3.modelli.Facade;
import it.uniroma3.modelli.RisultatoEsame;
import it.uniroma3.modelli.Utente;

public class VisualizzaRisultatiEsamiAction {

	public List<RisultatoEsame> execute(Utente utente){
		
		Facade facade = new Facade();
		facade.istanziaEntityManager();

		List<RisultatoEsame> r = facade.getAllRisultatoEsame();
		List<RisultatoEsame> r1 =  new ArrayList<>();
		for(RisultatoEsame rr : r) {
			if(rr.getUtente().equals(utente))
				r1.add(rr);
		}
		return r1;
	}
	
}
