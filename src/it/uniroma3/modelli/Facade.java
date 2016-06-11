package it.uniroma3.modelli;



import java.util.Date;
import java.util.List;

//import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import it.uniroma3.persistence.RisultatoEsameDaoJPA;
import it.uniroma3.persistence.TipologiaEsameDaoJPA;
import it.uniroma3.persistence.UtenteDaoJPA;


public class Facade {
	
	private static final String DB_NAME = "clinica-unit";
	
	public static final boolean DEBUG = true;
	
	private static final Facade singleton = new Facade();
	
	private EntityManagerFactory emf;
	
	private EntityManager em;
	
	
	
	public Facade() {}

	//istanzia l'entity manager
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
		TipologiaEsameDaoJPA tipologiaEsame = new TipologiaEsameDaoJPA(em);
		tipologiaEsame.save(e);
	}
	
    //inserimento di una nuova tipologia di esame
	public void inserisciRisultato(RisultatoEsame e) {
		RisultatoEsameDaoJPA risultatoEsame = new RisultatoEsameDaoJPA(em);
		risultatoEsame.save(e);
	}
	
    //inserimento di un utente
	public void inserisciUtente(Utente e) {
		UtenteDaoJPA utenteDao = new UtenteDaoJPA(em);
		utenteDao.save(e);
	}
	
    //restituisci tutti gli utenti attualmente istanziati nel database
	public List<Utente> getAllUtenti() {
		UtenteDaoJPA utenteDao = new UtenteDaoJPA(em);
		List<Utente> utenti = utenteDao.findAll();
		return utenti;
	}
	
    //restituisci tutti gli utenti attualmente istanziati nel database
	public List<RisultatoEsame> getAllRisultatoEsame() {
		RisultatoEsameDaoJPA risultatoEsameDao = new RisultatoEsameDaoJPA(em);
		List<RisultatoEsame> risultatiEsami = risultatoEsameDao.findAll();
		return risultatiEsami;
	}
	
    //restituisci tutti gli utenti attualmente istanziati nel database
	public Utente getUtenteByID(Long id) {
		UtenteDaoJPA utenteDao = new UtenteDaoJPA(em);
		Utente utente = utenteDao.findByPrimaryKey(id);
		return utente;
	}
	
	//restituisci i risultati del paziente il cui id è passato come parametro
//	public List<RisultatoEsame> trovaEsamiPaziente(Long id) {
//		RisultatoEsameDaoJPA risultatoEsame = new RisultatoEsameDaoJPA(em);
//		return risultatoEsame.findByPatient(id);
//	}
	
	
	public void closeEm() {
		em.close();
	}
	
	//verifica il login
	public Utente login(String username, String password) throws Exception {
		Utente u = new Utente();
		u.setCodiceFiscale("marRos");
		u.setNome("Mario");
		u.setCognome("Rossi");
		u.setUsername("mario");
		u.setPassword("rossi");
		u.setRuolo("AdmiN");
		if(username.equals("mario") && password.equals("rossi")) {
			return u;
		}
		else
			return null;
		
	}
}
