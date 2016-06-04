package it.uniroma3.persistence;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.uniroma3.modelli.Prenotazione;

public class PrenotazioneDaoJPA implements PrenotazioneDao {

	private EntityManager em;
	private EntityTransaction tx;

	public PrenotazioneDaoJPA(EntityManager em) {
		this.em=em;
	}

	@Override
	public void save(Prenotazione pre) {//SALVATAGGIO
		tx = em.getTransaction();
		tx.begin();
		em.persist(pre);
		tx.commit();
	}

	@Override
	public Prenotazione findByPrimaryKey(Long id) {
		return em.find(Prenotazione.class, id);
	}

	@Override
	public List<Prenotazione> findAll() {
		List<Prenotazione> pre = em.createQuery("SELECT p FROM prenotazione p").getResultList();
		return pre;
	}

	@Override
	public void update(Prenotazione pre) {//AGGIORNAMENTO
		tx = em.getTransaction();
		tx.begin();
		em.merge(pre);
		tx.commit();
	}

	@Override
	public void delete(Prenotazione pre) {//ELIMINAZIONE
		tx = this.em.getTransaction();
		tx.begin();
		em.remove(pre);
		tx.commit();
	}
}