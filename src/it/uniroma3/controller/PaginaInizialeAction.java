package it.uniroma3.controller;

import it.uniroma3.modelli.Facade;
import it.uniroma3.modelli.Prerequisito;
import it.uniroma3.modelli.TipologiaEsame;
import it.uniroma3.modelli.Utente;
import it.uniroma3.modelli.RisultatoEsame;
import it.uniroma3.modelli.Indicatore;

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
	
		RisultatoEsame r1 = new RisultatoEsame();
		Indicatore i1 = new Indicatore("Eritrociti","4.44");
		Indicatore i2 = new Indicatore("Emoglobina","12.60");
		Indicatore i3 = new Indicatore("Ematocrito","40.5");
		Indicatore i4 = new Indicatore("MCV","91.2");                                    
		Indicatore i5 = new Indicatore("MCH","28.4");
		Indicatore i6 = new Indicatore("RDW","13");
		Indicatore i7 = new Indicatore("Sideremia","82");
		Indicatore i8 = new Indicatore("Piastrine","213");
		r1.setUtente(s);
		r1.setTipologiaEsame(e2);
		r1.setNome(e2.getDescrizione());
		r1.addIndicatore(i1);
		r1.addIndicatore(i2);
		r1.addIndicatore(i3);
		r1.addIndicatore(i4);
		r1.addIndicatore(i5);
		r1.addIndicatore(i6);
		r1.addIndicatore(i7);
		r1.addIndicatore(i8);
		
		RisultatoEsame r2 = new RisultatoEsame();
		Indicatore i9 = new Indicatore("Miopia lieve: Occhio sinistro","0.5");
		Indicatore i10 = new Indicatore("Miopia lieve: Occhio destro","0.75");
		r2.setUtente(s);
		r2.setTipologiaEsame(e1);
		r2.setNome(e1.getDescrizione());
		r2.addIndicatore(i9);
		r2.addIndicatore(i10);


		
		long i = 6;
		if(facade.getUtenteByID(i)==null)
		{	
		facade.inserisciTipologia(e1);
		facade.inserisciTipologia(e2);
		facade.inserisciUtente(m);
		facade.inserisciUtente(s);
		facade.inserisciRisultato(r1);
		facade.inserisciRisultato(r2);
		}
		
		facade.closeEm();
	}
	
}
