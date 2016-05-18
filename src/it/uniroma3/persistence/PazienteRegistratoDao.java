package it.uniroma3.persistence;

import it.uniroma3.modelli.Utente; //DA CREARE CLASSE PazienteRegistrato JPA

import java.util.List;

public interface PazienteRegistratoDao {

	public void save(Utente paziente);  // Create
	public Utente findByPrimaryKey(Long id);     // Retrieve
	public List<Utente> findAll();       
	public void update(Utente paziente); //Update
	public void delete(Utente paziente); //Delete
	
}