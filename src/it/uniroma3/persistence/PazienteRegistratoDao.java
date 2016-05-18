package it.uniroma3.persistence;

import it.uniroma3.modelli.PazienteRegistrato; //DA CREARE CLASSE PazienteRegistrato JPA

import java.util.List;

public interface PazienteRegistratoDao {

	public void save(PazienteRegistrato paziente);  // Create
	public PazienteRegistrato findByPrimaryKey(Long id);     // Retrieve
	public List<PazienteRegistrato> findAll();       
	public void update(PazienteRegistrato paziente); //Update
	public void delete(PazienteRegistrato paziente); //Delete
	
}