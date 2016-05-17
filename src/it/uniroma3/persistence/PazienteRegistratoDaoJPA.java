package it.uniroma3.persistence;

import it.uniroma3.modelli.PazienteRegistrato;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PazienteRegistratoDaoJPA implements PazienteRegistartoDao {

	//STABILISCO LA CONNESSIONE CON IL DATABASE
	private EntityManager em;
	private EntityTransaction tx;

	public PazienteRegistratoDaoJPA(EntityManager em) {
		this.em=em;
	}
//INIZIO A FARE LE VARIE RICHIESTE DI:
	@Override
	public void save(PazienteRegistrato paziente) {//SALVATAGGIO
		tx = em.getTransaction();
		tx.begin();
		em.persist(paziente);
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
		List<PazienteRegistrato> paziente = em.createQuery("SELECT p FROM PazienteRegistrato p").getResultList();
		return paziente;
	}

	@Override
	public void update(PazienteRegistrato paziente) {//AGGIORNAMENTO
		tx = em.getTransaction();
		tx.begin();
		em.merge(paziente);
		tx.commit();
	}

	@Override
	public void delete(PazienteRegistrato paziente) {//ELIMINAZIONE
		tx = this.em.getTransaction();
		tx.begin();
		em.remove(paziente);
		tx.commit();
	}
}
