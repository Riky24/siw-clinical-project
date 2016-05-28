package it.uniroma3.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.uniroma3.modelli.TipologiaEsame;
import it.uniroma3.modelli.Prerequisito;
import it.uniroma3.persistence.TipologiaEsameDaoJPA;

public class ElencoEsamiOfferti {

	private TipologiaEsame e = new TipologiaEsame();
	private Map<String, TipologiaEsame> esamiOfferti;
	
	ElencoEsamiOfferti() {
		
	}

	public void inizializza() {
		
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
//		EntityManager em = emf.createEntityManager();
		
		
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
		
		
//		EsamiOffertiDaoJPA esamiOffertiDao = new EsamiOffertiDaoJPA(em);
//		esamiOffertiDao.save(e1);
//		esamiOffertiDao.save(e2);
		
		
		this.esamiOfferti = new HashMap<>();
		this.esamiOfferti.put(e1.getCodice(), e1);
		this.esamiOfferti.put(e2.getCodice(), e2);
//		this.esamiOfferti = esamiOffertiDao.findAll();
		
//		emf.close();
	}
	
	public Map<String, TipologiaEsame> getEsami() {
		return this.esamiOfferti;
	}
	
	
}