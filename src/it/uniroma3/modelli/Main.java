package it.uniroma3.modelli;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.uniroma3.persistence.EsamiOffertiDaoJPA;
import it.uniroma3.persistence.PazienteRegistratoDaoJPA;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		EntityManager em = emf.createEntityManager();
		
		


		EsamiOfferti e = new EsamiOfferti();
		Prerequisito p1 = new Prerequisito("1 eye", "E' necessario avere almeno un occhio");
		Prerequisito p2 = new Prerequisito("no lens", "Non si devono indossare lenti a contatto");
		e.setDescrizione("Esame della vista");
		e.setNome("vista");
		e.setCodice("v");
		e.setCosto("70 euro");
		e.addPrerequisito(p1);
		e.addPrerequisito(p2);
		
		PazienteRegistrato p = new PazienteRegistrato();
		p.setNome("Luca");
		p.setCognome("Iannotta");
		p.setCodiceFiscale("nnt25mmmm");

		
		
		EsamiOffertiDaoJPA esamiOffertiDao = new EsamiOffertiDaoJPA(em);
		esamiOffertiDao.save(e);

		PazienteRegistratoDaoJPA pazienteDao = new PazienteRegistratoDaoJPA(em);
		pazienteDao.save(p);
		
		
		
		em.close();
		emf.close();
	}

}
