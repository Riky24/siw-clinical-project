package it.uniroma3.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import it.uniroma3.modelli.EsamiOfferti;


public class EsamiOffertiDaoJPA implements EsamiOffertiDao{

	//STABILISCO LA CONNESSIONE CON IL DATABASE
	private EntityManager em;
	private EntityTransaction tx;

	public EsamiOffertiDaoJPA(EntityManager em) {
		this.em=em;
	}
//INIZIO A FARE LE VARIE RICHIESTE DI:
	@Override
	public void save(EsamiOfferti esameOfferto) {//SALVATAGGIO
		tx = em.getTransaction();
		tx.begin();
		em.persist(esameOfferto);
		tx.commit();
	}
//pongo id come chiave primaria
	@Override
	public EsamiOfferti findByPrimaryKey(String nome) {
		return em.find(EsamiOfferti.class, nome);
	}
//faccio una query per la lista degli ordini
	@Override
	public List<EsamiOfferti> findAll() {
		List<EsamiOfferti> esameOfferto = em.createQuery("SELECT e FROM EsamiOfferti e").getResultList();
		return esameOfferto;
	}

	@Override
	public void update(EsamiOfferti esameOfferto) {//AGGIORNAMENTO
		tx = em.getTransaction();
		tx.begin();
		em.merge(esameOfferto);
		tx.commit();
	}

	@Override
	public void delete(EsamiOfferti esameOfferto) {//ELIMINAZIONE
		tx = this.em.getTransaction();
		tx.begin();
		em.remove(esameOfferto);
		tx.commit();
	}
}
