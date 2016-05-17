package it.uniroma3.modelli;



import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import it.uniroma3.persistence.EsamiOffertiDao;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");

		EsamiOffertiDao esamiOffertiDao = new EsamiOffertiDao(emf);


		EsamiOfferti e = new EsamiOfferti();
		Prerequisito p1 = new Prerequisito("1 eye", "E' necessario avere almeno un occhio");
		Prerequisito p2 = new Prerequisito("no lens", "Non si devono indossare lenti a contatto");
		e.setDescrizione("Esame della vista");
		e.setNome("vista");
		e.setCodice("v");
		e.setCosto("70 euro");
		e.addPrerequisito(p1);
		e.addPrerequisito(p2);

		esamiOffertiDao.save(e);
		emf.close();
	}

}
