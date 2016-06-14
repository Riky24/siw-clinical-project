package it.uniroma3.controller;

import it.uniroma3.modelli.Facade;
import it.uniroma3.modelli.TipologiaEsame;

public class DettagliTipologiaEsameAction {

	public TipologiaEsame execute(Long l){
		
		Facade facade = new Facade();
		facade.istanziaEntityManager();

		TipologiaEsame r = facade.getTipologiaByID(l);
		
		return r;
	}
	
}
