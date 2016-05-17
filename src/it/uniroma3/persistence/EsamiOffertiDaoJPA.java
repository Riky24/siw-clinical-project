package it.uniroma3.persistence;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.modelli.EsamiOfferti;

public class EsamiOffertiDaoJPA implements Dao<EsamiOfferti>{
	//STABILISCO LA CONNESSIONE CON IL DATABASE
	private  static EntityManagerFactory emf;

	public EsamiOffertiDaoJPA(EntityManagerFactory emf) {
		this.emf = emf;
	}

	//INIZIO A FARE LE VARIE RICHIESTE DI:
	public void save(EsamiOfferti c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
		em.close();
	}

	//pongo id come chiave primaria
	public EsamiOfferti findById(long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		EsamiOfferti c = em.find(EsamiOfferti.class, id);
		tx.commit();
		em.close();
		return c;
	}

	public void delete(EsamiOfferti c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		EsamiOfferti toRemove = em.merge(c);
		em.remove(toRemove);
		tx.commit();		
		em.close();
	}

	public void update(EsamiOfferti c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(c);
		tx.commit();
		em.close();
	}

	//faccio una query per la lista degli ordini
	@SuppressWarnings("unchecked")
	public List<EsamiOfferti> findAll() {
		EntityManager em = emf.createEntityManager();
		List<EsamiOfferti> result = em.createNamedQuery("EsamiOfferti.findAll").getResultList();
		em.close();
		return result;
	}

	public void closeEmf() {
		emf.close();
	}

}
