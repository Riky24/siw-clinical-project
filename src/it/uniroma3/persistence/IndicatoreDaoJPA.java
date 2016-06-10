package it.uniroma3.persistence;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.uniroma3.modelli.Indicatore;



public class IndicatoreDaoJPA implements IndicatoreDao {
	//STABILISCO LA CONNESSIONE CON IL DATABASE
	private EntityManager em;
	private EntityTransaction tx;

	public IndicatoreDaoJPA(EntityManager em) {
		this.em=em;
	}
//INIZIO A FARE LE VARIE RICHIESTE DI:
	@Override
	public void save(Indicatore indicatore) {//SALVATAGGIO
		tx = em.getTransaction();
		tx.begin();
		em.persist(indicatore);
		tx.commit();
	}
//pongo id come chiave primaria
	@Override
	public Indicatore findByPrimaryKey(Long id) {
		return em.find(Indicatore.class, id);
	}
	
//faccio una query per la lista degli tipologie esame
	@SuppressWarnings("unchecked")
	@Override
	public List<Indicatore> findAll() {
		List<Indicatore> indicatore = em.createQuery("RisultatoEsame.findAll").getResultList();
		return indicatore;
	}

	@Override
	public void update(Indicatore indicatore) {//AGGIORNAMENTO
		tx = em.getTransaction();
		tx.begin();
		em.merge(indicatore);
		tx.commit();
	}

	@Override
	public void delete(Indicatore esamiOfferti) {//ELIMINAZIONE
		tx = this.em.getTransaction();
		tx.begin();
		em.remove(esamiOfferti);
		tx.commit();
	}
}

