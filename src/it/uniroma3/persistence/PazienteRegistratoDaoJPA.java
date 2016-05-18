package it.uniroma3.persistence;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.modelli.PazienteRegistrato;

public class PazienteRegistratoDaoJPA implements Dao<PazienteRegistrato>{
	//STABILISCO LA CONNESSIONE CON IL DATABASE
	private  static EntityManagerFactory emf;

	public PazienteRegistratoDaoJPA(EntityManagerFactory emf) {
		this.emf = emf;
	}

	//INIZIO A FARE LE VARIE RICHIESTE DI:
	public void save(PazienteRegistrato p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(p);
		tx.commit();
		em.close();
	}

	//pongo id come chiave primaria
	public PazienteRegistrato findById(long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		PazienteRegistrato p = em.find(PazienteRegistrato.class, id);
		tx.commit();
		em.close();
		return p;
	}

	public void delete(PazienteRegistrato p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		PazienteRegistrato toRemove = em.merge(p);
		em.remove(toRemove);
		tx.commit();		
		em.close();
	}

	public void update(PazienteRegistrato p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(p);
		tx.commit();
		em.close();
	}

	//faccio una query per la lista degli ordini
	@SuppressWarnings("unchecked")
	public List<PazienteRegistrato> findAll() {
		EntityManager em = emf.createEntityManager();
		List<PazienteRegistrato> result = em.createNamedQuery("PazienteRegistrato.findAll").getResultList();
		em.close();
		return result;
	}

	public void closeEmf() {
		emf.close();
	}



}