package it.uniroma3.modelli;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.uniroma3.persistence.UtenteDaoJPA;
import it.uniroma3.persistence.PrenotazioneDaoJPA;
import it.uniroma3.persistence.PrerequisitoDaoJPA;
import it.uniroma3.persistence.RisultatoEsameDaoJPA;
import it.uniroma3.persistence.TipologiaEsameDaoJPA;

public class Main {

	public static void main(String[] args) throws Exception {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		EntityManager em = emf.createEntityManager();

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


//		TipologiaEsame e1 = new TipologiaEsame();
//		Prerequisito p11 = new Prerequisito("1 eye", "E' necessario avere almeno un occhio");
//		Prerequisito p12 = new Prerequisito("no lens", "Non si devono indossare lenti a contatto");
//		e1.setDescrizione("Esame della vista");
//		e1.setNome("vista");
//		e1.setCodice("vi");
//		e1.setCosto("70 euro");
//		e1.addPrerequisito(p11);
//		e1.addPrerequisito(p12);
//
//		TipologiaEsame e2 = new TipologiaEsame();
//		Prerequisito p21 = new Prerequisito("no breakfast", "Non bisogna aver fatto colazione il giorno dell'esame");
//		e2.setDescrizione("Esame del sangue");
//		e2.setNome("sangue");
//		e2.setCodice("sa");
//		e2.setCosto("20 euro");
//		e2.addPrerequisito(p21);
//
//		Utente u1 = new Utente();
//		u1.setNome("Mario");
//		u1.setCognome("Rossi");
//		u1.setRuolo("admin");
//		u1.setUsername("mario");
//		u1.setPassword("rossi");
//		u1.setCodiceFiscale("codiceMario");
//
//		Utente u2 = new Utente();
//		u2.setNome("Rossi");
//		u2.setCognome("Mario");
//		u2.setRuolo("user");
//		u2.setUsername("rossi");
//		u2.setPassword("mario");
//		u2.setCodiceFiscale("codiceRossi");
//
//		Prenotazione pr = new Prenotazione();
//		pr.setUtente(u2);
//		pr.setTipologiaEsame(e2);


		TipologiaEsameDaoJPA tipologiaEsameDao = new TipologiaEsameDaoJPA(em);
		tipologiaEsameDao.save(e1);
		tipologiaEsameDao.save(e2);

		
		UtenteDaoJPA utentiDao = new UtenteDaoJPA(em);
		utentiDao.save(m);
		utentiDao.save(s);

		
		PrenotazioneDaoJPA prenotazioneDao = new PrenotazioneDaoJPA(em);
//		prenotazioneDao.save(pr);

		RisultatoEsameDaoJPA risultatoEsameDao = new RisultatoEsameDaoJPA(em);
		risultatoEsameDao.save(r1);
		risultatoEsameDao.save(r2);
		
//		List<RisultatoEsame> r = risultatoEsameDao.findAll();
		
//		List<Utente> uuu = utentiDao.findAll();
		
//		for(RisultatoEsame ll : r)
//			System.out.println(ll.getNome());
		
//		for(Utente lll : uuu)
//			System.out.println(lll.getNome());
		
		//		System.out.println(esamiOffertiDao.findByPrimaryKey(e1.getId()).getDescrizione() + ", " 
		//		+ esamiOffertiDao.findByPrimaryKey(e1.getId()).getCosto() + " e " + esamiOffertiDao.findByPrimaryKey(e1.getId()).getId());
		//
		//		
		//		
//				List<Utente> list = utentiDao.findAll();
//				for(Utente u : list) {
//					System.out.println(u.getCodiceFiscale());
//				}

		//		PazienteRegistratoDaoJPA pazienteDao = new PazienteRegistratoDaoJPA(em);
		//		pazienteDao.save(p);



		em.close();
		emf.close();
	}

}
