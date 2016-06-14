package it.uniroma3.persistence;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.uniroma3.modelli.Utente;

public class UtenteDaoJPA implements UtenteDao {
	//STABILISCO LA CONNESSIONE CON IL DATABASE
	private EntityManager em;
	private EntityTransaction tx;

	public UtenteDaoJPA(EntityManager em) {
		this.em=em;
	}
//INIZIO A FARE LE VARIE RICHIESTE DI:
	@Override
	public void save(Utente utente) {//SALVATAGGIO
		tx = em.getTransaction();
		tx.begin();
		em.persist(utente);
		tx.commit();
	}
//pongo id come chiave primaria
	@Override
	public Utente findByPrimaryKey(Long id) {
		return em.find(Utente.class, id);
	}
	
	
	
//faccio una query per la lista degli utenti
	@SuppressWarnings("unchecked")
	@Override
	public List<Utente> findAll() {
//		List<Utente> utente = em.createQuery("SELECT o FROM utente o").getResultList();
		List<Utente> utente = em.createNamedQuery("Utente.findAll").getResultList();
//		em.clear();
		return utente;
	}

	@Override
	public void update(Utente utente) {//AGGIORNAMENTO
		tx = em.getTransaction();
		tx.begin();
		em.merge(utente);
		tx.commit();
	}

	@Override
	public void delete(Utente utente) {//ELIMINAZIONE
		tx = this.em.getTransaction();
		tx.begin();
		em.remove(utente);
		tx.commit();
	}
	
	public Utente findByCodFiscale(String codFis) {
		em.createQuery("select u from Utente u where u.codiceFiscale like :codFis").setParameter("codFis", codFis).getSingleResult();
		return null;
	}
}