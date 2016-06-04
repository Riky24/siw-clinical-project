package it.uniroma3.persistence;

import it.uniroma3.modelli.Prenotazione;

import java.util.List;

public interface PrenotazioneDao {

	public void save(Prenotazione pre);            // Create
	public Prenotazione findByPrimaryKey(Long id); // Retrieve
	public List<Prenotazione> findAll();       
	public void update(Prenotazione pre);          //Update
	public void delete(Prenotazione pre);          //Delete
}