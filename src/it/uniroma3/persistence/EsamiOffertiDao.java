/*package it.uniroma3.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.modelli.EsamiOfferti;

public class EsamiOffertiDao implements Dao<EsamiOfferti>{
private  static EntityManagerFactory emf;

	public EsamiOffertiDao(EntityManagerFactory emf) {
		this.emf = emf;
}

	public void save(EsamiOfferti c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
		em.close();
	}

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

}*/


//import it.uniroma3.modelli.EsamiOfferti; //MODIFICARE NOME E CODICE CLASSE servizi in EsamiOfferti jpa
//
//public class EsamiOffertiDao {
//
//	public void save(EsamiOfferti esameOfferto);  // Create
//	public EsamiOfferti findByPrimaryKey(String nome);     // Retrieve
//	public List<EsameOfferti> findAll();       
//	public void update(EsamiOfferti esameOfferto); //Update
//	public void delete(EsamiOfferti esameOfferto); //Delete
//	
//}
//>>>>>>> refs/remotes/origin/master
