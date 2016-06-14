package it.uniroma3.controller;

import java.util.ArrayList;
import java.util.List;

import it.uniroma3.modelli.Facade;
import it.uniroma3.modelli.TipologiaEsame;
import it.uniroma3.modelli.Utente;

public class VisualizzaTipologieEsamiAction {

	
	public List<TipologiaEsame> execute(){
		
		Facade facade = new Facade();
		facade.istanziaEntityManager();
		List<TipologiaEsame> r = facade.getTipologieEsami();
//		List<TipologiaEsame> r1 =  new ArrayList<>();
//		for(TipologiaEsame rr : r) {
//			if(rr.getUtente().equals(utente))
//				r1.add(rr);
//		}
		return r;
	}
}
