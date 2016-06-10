package it.uniroma3.persistence;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.uniroma3.modelli.RisultatoEsame;



public class RisultatoEsameDaoJPA implements RisultatoEsameDao {
	//STABILISCO LA CONNESSIONE CON IL DATABASE
	private EntityManager em;
	private EntityTransaction tx;

	public RisultatoEsameDaoJPA(EntityManager em) {
		this.em=em;
	}
//INIZIO A FARE LE VARIE RICHIESTE DI:
	@Override
	public void save(RisultatoEsame risultatoEsame) {//SALVATAGGIO
		tx = em.getTransaction();
		tx.begin();
		em.persist(risultatoEsame);
		tx.commit();
	}
//pongo id come chiave primaria
	@Override
	public RisultatoEsame findByPrimaryKey(Long id) {
		return em.find(RisultatoEsame.class, id);
	}
	
//faccio una query per la lista degli tipologie esame
	@SuppressWarnings("unchecked")
	@Override
	public List<RisultatoEsame> findAll() {
		List<RisultatoEsame> risultatoEsame = em.createQuery("RisultatoEsame.findAll").getResultList();
		return risultatoEsame;
	}

	@Override
	public void update(RisultatoEsame risultatoEsame) {//AGGIORNAMENTO
		tx = em.getTransaction();
		tx.begin();
		em.merge(risultatoEsame);
		tx.commit();
	}

	@Override
	public void delete(RisultatoEsame risultatoEsame) {//ELIMINAZIONE
		tx = this.em.getTransaction();
		tx.begin();
		em.remove(risultatoEsame);
		tx.commit();
	}
}
