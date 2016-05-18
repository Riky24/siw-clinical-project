package it.uniroma3.persistence;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.uniroma3.modelli.Prerequisito;



public class PrerequisitoDaoJPA implements PrerequisitoDao {
	//STABILISCO LA CONNESSIONE CON IL DATABASE
	private EntityManager em;
	private EntityTransaction tx;

	public PrerequisitoDaoJPA(EntityManager em) {
		this.em=em;
	}
//INIZIO A FARE LE VARIE RICHIESTE DI:
	@Override
	public void save(Prerequisito prerequisito) {//SALVATAGGIO
		tx = em.getTransaction();
		tx.begin();
		em.persist(prerequisito);
		tx.commit();
	}
//pongo id come chiave primaria
	@Override
	public Prerequisito findByPrimaryKey(Long id) {
		return em.find(Prerequisito.class, id);
	}
//faccio una query per la lista degli ordini
	@Override
	public List<Prerequisito> findAll() {
		List<Prerequisito> prerequisito = em.createQuery("SELECT o FROM prerequisito o").getResultList();
		return prerequisito;
	}

	@Override
	public void update(Prerequisito prerequisito) {//AGGIORNAMENTO
		tx = em.getTransaction();
		tx.begin();
		em.merge(prerequisito);
		tx.commit();
	}

	@Override
	public void delete(Prerequisito prerequisito) {//ELIMINAZIONE
		tx = this.em.getTransaction();
		tx.begin();
		em.remove(prerequisito);
		tx.commit();
	}
}
