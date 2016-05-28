package it.uniroma3.modelli;



import java.util.Date;

//import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import it.uniroma3.persistence.TipologiaEsameDaoJPA;


public class Facade {
	
	private static final String DB_NAME = "clinica-unit";
	
	public static final boolean DEBUG = true;
	
	private static final Facade singleton = new Facade();
	
	private EntityManagerFactory emf;
	
	private EntityManager em;
	
	
	
	public Facade() {}

	public void istanziaEntityManager() {
		try {
			em = this.getInstance().getEntityManagerFactory().createEntityManager();
		}
		catch(Exception e) {
			//handle error....
			System.out.println("Problema con l'Entity Manager");
		}
	}

    public EntityManagerFactory getEntityManagerFactory() {
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory(DB_NAME);
        }
        if(DEBUG) {
            System.out.println("factory created on: " + new Date());
        }
        return emf;
    }
	
    public static Facade getInstance() {
        return singleton;
    }
	
    public void closeEmf() {
        if(emf.isOpen() || emf != null) {
            emf.close();
        }
        emf = null;
        if(DEBUG) {
            System.out.println("EMF closed at: " + new Date());
        }
    }
	
    
    //inserimento di una nuova tipologia di esame
	public void inserisciTipologia(TipologiaEsame e) {
		TipologiaEsameDaoJPA esamiOffertiDao = new TipologiaEsameDaoJPA(em);
		esamiOffertiDao.save(e);
		em.close();
	}
}
