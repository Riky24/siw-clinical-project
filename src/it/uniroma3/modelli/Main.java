package it.uniroma3.modelli;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.uniroma3.persistence.EsamiOffertiDaoJPA;
import it.uniroma3.persistence.PazienteRegistratoDaoJPA;
import it.uniroma3.persistence.PrerequisitoDaoJPA;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		EntityManager em = emf.createEntityManager();
		
		


		EsamiOfferti e1 = new EsamiOfferti();
		Prerequisito p11 = new Prerequisito("1 eye", "E' necessario avere almeno un occhio");
		Prerequisito p12 = new Prerequisito("no lens", "Non si devono indossare lenti a contatto");
		e1.setDescrizione("Esame della vista");
		e1.setNome("vista");
		e1.setCodice("vi");
		e1.setCosto("70 euro");
		e1.addPrerequisito(p11);
		e1.addPrerequisito(p12);
		
		EsamiOfferti e2 = new EsamiOfferti();
		Prerequisito p21 = new Prerequisito("no breakfast", "Non bisogna aver fatto colazione il giorno dell'esame");
		e2.setDescrizione("Esame del sangue");
		e2.setNome("sangue");
		e2.setCodice("sa");
		e2.setCosto("20 euro");
		e2.addPrerequisito(p21);
		
		
		
//		Utente p = new Utente();
//		p.setNome("Luca");
//		p.setCognome("Iannotta");
//		p.setCodiceFiscale("nnt25mmmm");

		
		
		
		EsamiOffertiDaoJPA esamiOffertiDao = new EsamiOffertiDaoJPA(em);
		esamiOffertiDao.save(e1);
		esamiOffertiDao.save(e2);
		
		
		
//		System.out.println(esamiOffertiDao.findByPrimaryKey(e1.getId()).getDescrizione() + ", " 
//		+ esamiOffertiDao.findByPrimaryKey(e1.getId()).getCosto() + " e " + esamiOffertiDao.findByPrimaryKey(e1.getId()).getId());
//
//		
//		
//		List<Prerequisito> list = esamiOffertiDao.findByPrimaryKey(e1.getId()).getPrerequisiti();
//		for(Prerequisito pre : list) {
//			System.out.println(pre.getValore());
//		}
		
//		PazienteRegistratoDaoJPA pazienteDao = new PazienteRegistratoDaoJPA(em);
//		pazienteDao.save(p);

		
		
		em.close();
		emf.close();
	}

}
