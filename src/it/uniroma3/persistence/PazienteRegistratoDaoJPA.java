package it.uniroma3.persistence;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.uniroma3.modelli.PazienteRegistrato;

public class PazienteRegistratoDaoJPA implements PazienteRegistratoDao {
	//STABILISCO LA CONNESSIONE CON IL DATABASE
	private EntityManager em;
	private EntityTransaction tx;

	public PazienteRegistratoDaoJPA(EntityManager em) {
		this.em=em;
	}
//INIZIO A FARE LE VARIE RICHIESTE DI:
	@Override
	public void save(PazienteRegistrato pazienteRegistrato) {//SALVATAGGIO
		tx = em.getTransaction();
		tx.begin();
		em.persist(pazienteRegistrato);
		tx.commit();
	}
//pongo id come chiave primaria
	@Override
	public PazienteRegistrato findByPrimaryKey(Long id) {
		return em.find(PazienteRegistrato.class, id);
	}
//faccio una query per la lista degli ordini
	@Override
	public List<PazienteRegistrato> findAll() {
		List<PazienteRegistrato> pazienteRegistrato = em.createQuery("SELECT o FROM pazienteregistrato o").getResultList();
		return pazienteRegistrato;
	}

	@Override
	public void update(PazienteRegistrato pazienteRegistrato) {//AGGIORNAMENTO
		tx = em.getTransaction();
		tx.begin();
		em.merge(pazienteRegistrato);
		tx.commit();
	}

	@Override
	public void delete(PazienteRegistrato pazienteRegistrato) {//ELIMINAZIONE
		tx = this.em.getTransaction();
		tx.begin();
		em.remove(pazienteRegistrato);
		tx.commit();
	}
}