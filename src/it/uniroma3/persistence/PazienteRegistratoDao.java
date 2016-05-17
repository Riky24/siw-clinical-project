package it.uniroma3.persistence;

import it.uniroma3.modelli.PazienteRegistrato; //DA CREARE CLASSE PazienteRegistrato JPA

import java.util.List;

public class PazienteRegistratoDao {

	public void save(PazienteRegistratoDao paziente);  // Create
	public PazienteRegistratoDao findByPrimaryKey(Long id);     // Retrieve
	public List<EsameOfferti> findAll();       
	public void update(PazienteRegistratoDao paziente); //Update
	public void delete(PazienteRegistratoDao paziente); //Delete
	
}