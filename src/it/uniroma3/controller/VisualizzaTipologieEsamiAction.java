package it.uniroma3.controller;


import java.util.List;

import it.uniroma3.modelli.Facade;
import it.uniroma3.modelli.TipologiaEsame;


public class VisualizzaTipologieEsamiAction {

	
	public List<TipologiaEsame> execute(){
		
		Facade facade = new Facade();
		facade.istanziaEntityManager();
		List<TipologiaEsame> r = facade.getTipologieEsami();

		return r;
	}
}
