package it.uniroma3.persistence;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.uniroma3.modelli.TipologiaEsame;
import it.uniroma3.modelli.Utente;



public class TipologiaEsameDaoJPA implements TipologiaEsameDao {
	//STABILISCO LA CONNESSIONE CON IL DATABASE
	private EntityManager em;
	private EntityTransaction tx;

	public TipologiaEsameDaoJPA(EntityManager em) {
		this.em=em;
	}
//INIZIO A FARE LE VARIE RICHIESTE DI:
	@Override
	public void save(TipologiaEsame esamiOfferti) {//SALVATAGGIO
		tx = em.getTransaction();
		tx.begin();
		em.persist(esamiOfferti);
		tx.commit();
	}
//pongo id come chiave primaria
	@Override
	public TipologiaEsame findByPrimaryKey(Long id) {
		return em.find(TipologiaEsame.class, id);
	}
	
//faccio una query per la lista degli tipologie esame
	@SuppressWarnings("unchecked")
	@Override
	public List<TipologiaEsame> findAll() {
		List<TipologiaEsame> esamiOfferti = em.createNamedQuery("TipologiaEsame.findAll").getResultList();
		return esamiOfferti;
	}

	@Override
	public void update(TipologiaEsame esamiOfferti) {//AGGIORNAMENTO
		tx = em.getTransaction();
		tx.begin();
		em.merge(esamiOfferti);
		tx.commit();
	}

	@Override
	public void delete(TipologiaEsame esamiOfferti) {//ELIMINAZIONE
		tx = this.em.getTransaction();
		tx.begin();
		em.remove(esamiOfferti);
		tx.commit();
	}
}
