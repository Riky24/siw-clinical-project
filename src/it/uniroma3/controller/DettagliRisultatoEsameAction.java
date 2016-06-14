package it.uniroma3.controller;



import it.uniroma3.modelli.Facade;
import it.uniroma3.modelli.RisultatoEsame;


public class DettagliRisultatoEsameAction {

	public RisultatoEsame execute(Long l){
		
		Facade facade = new Facade();
		facade.istanziaEntityManager();

		RisultatoEsame r = facade.getRisultatoByID(l);
		
		return r;
	}
	
}
