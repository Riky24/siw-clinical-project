package it.uniroma3.controller;

import java.util.ArrayList;
import java.util.List;

import it.uniroma3.modelli.Facade;
import it.uniroma3.modelli.RisultatoEsame;
import it.uniroma3.modelli.Utente;

public class DettagliRisultatoEsameAction {

	public RisultatoEsame execute(Long l){
		
		Facade facade = new Facade();
		facade.istanziaEntityManager();

		RisultatoEsame r = facade.getRisultatoByID(l);
		
		return r;
	}
	
}
