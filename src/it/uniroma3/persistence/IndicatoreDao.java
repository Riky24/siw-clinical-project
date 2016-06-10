package it.uniroma3.persistence;

import java.util.List;

import it.uniroma3.modelli.Indicatore;

public interface IndicatoreDao {

	public void save(Indicatore esamiOffert);  // Create
	public Indicatore findByPrimaryKey(Long id);     // Retrieve
	public List<Indicatore> findAll();       
	public void update(Indicatore esamiOffert); //Update
	public void delete(Indicatore esamiOffert); //Delete
	
}
