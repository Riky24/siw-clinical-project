package it.uniroma3.controller;

import it.uniroma3.modelli.Facade;
import it.uniroma3.modelli.Prerequisito;
import it.uniroma3.modelli.TipologiaEsame;
import it.uniroma3.modelli.Utente;

public class PaginaInizialeAction {

    public PaginaInizialeAction() {
    }
	
	public void inizializzaDatabase() throws Exception {
		
		Facade facade = new Facade();
		facade.istanziaEntityManager();

			
		TipologiaEsame e1 = new TipologiaEsame();
		Prerequisito p11 = new Prerequisito("1 eye", "E' necessario avere almeno un occhio");
		Prerequisito p12 = new Prerequisito("no lens", "Non si devono indossare lenti a contatto");
		e1.setDescrizione("Esame della vista");
		e1.setNome("vista");
		e1.setCodice("vi");
		e1.setCosto("70 euro");
		e1.addPrerequisito(p11);
		e1.addPrerequisito(p12);

		TipologiaEsame e2 = new TipologiaEsame();
		Prerequisito p21 = new Prerequisito("no breakfast", "Non bisogna aver fatto colazione il giorno dell'esame");
		e2.setDescrizione("Esame del sangue");
		e2.setNome("sangue");
		e2.setCodice("sa");
		e2.setCosto("20 euro");
		e2.addPrerequisito(p21);
		
		Utente m = new Utente();
		m.setNome("Mario");
		m.setCognome("Rossi");
		m.setCodiceFiscale("MRRSS");
		m.setUsername("mario");
		m.setPassword("rossi");
		m.setRuolo("admin");
		
		Utente s = new Utente();
		s.setNome("Stefano");
		s.setCognome("Bianchi");
		s.setCodiceFiscale("STFBN");
		s.setUsername("stefano");
		s.setPassword("bianchi");
		s.setRuolo("user");
	
		
		long i = 6;
		if(facade.getUtenteByID(i)==null)
		{	
		facade.inserisciTipologia(e1);
		facade.inserisciTipologia(e2);
		facade.inserisciUtente(m);
		facade.inserisciUtente(s);
		}
		
		facade.closeEm();
	}
	
}
