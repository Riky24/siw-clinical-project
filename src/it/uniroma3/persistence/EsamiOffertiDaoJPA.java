package it.uniroma3.persistence;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.uniroma3.modelli.EsamiOfferti;



public class EsamiOffertiDaoJPA implements EsamiOffertiDao {
	//STABILISCO LA CONNESSIONE CON IL DATABASE
	private EntityManager em;
	private EntityTransaction tx;

	public EsamiOffertiDaoJPA(EntityManager em) {
		this.em=em;
	}
//INIZIO A FARE LE VARIE RICHIESTE DI:
	@Override
	public void save(EsamiOfferti esamiOfferti) {//SALVATAGGIO
		tx = em.getTransaction();
		tx.begin();
		em.persist(esamiOfferti);
		tx.commit();
	}
//pongo id come chiave primaria
	@Override
	public EsamiOfferti findByPrimaryKey(Long id) {
		return em.find(EsamiOfferti.class, id);
	}
//faccio una query per la lista degli ordini
	@Override
	public List<EsamiOfferti> findAll() {
		List<EsamiOfferti> esamiOfferti = em.createQuery("SELECT o FROM esamiofferti o").getResultList();
		return esamiOfferti;
	}

	@Override
	public void update(EsamiOfferti esamiOfferti) {//AGGIORNAMENTO
		tx = em.getTransaction();
		tx.begin();
		em.merge(esamiOfferti);
		tx.commit();
	}

	@Override
	public void delete(EsamiOfferti esamiOfferti) {//ELIMINAZIONE
		tx = this.em.getTransaction();
		tx.begin();
		em.remove(esamiOfferti);
		tx.commit();
	}
}
