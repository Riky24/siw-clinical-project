package it.uniroma3.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.modelli.Prerequisito;

public class PrerequisitoDao implements Dao<Prerequisito>{
	private  static EntityManagerFactory emf;

	public PrerequisitoDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void save(Prerequisito c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
		em.close();
	}

	public Prerequisito findById(long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Prerequisito c = em.find(Prerequisito.class, id);
		tx.commit();
		em.close();
		return c;
	}

	public void delete(Prerequisito c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Prerequisito toRemove = em.merge(c);
		em.remove(toRemove);
		tx.commit();		
		em.close();
	}

	public void update(Prerequisito c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(c);
		tx.commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	public List<Prerequisito> findAll() {
		EntityManager em = emf.createEntityManager();
		List<Prerequisito> result = em.createNamedQuery("Prerequisito.findAll").getResultList();
		em.close();
		return result;
	}

	public void closeEmf() {
		emf.close();
	}

}

