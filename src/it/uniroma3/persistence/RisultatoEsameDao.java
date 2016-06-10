package it.uniroma3.persistence;

import java.util.List;

import it.uniroma3.modelli.RisultatoEsame;

public interface RisultatoEsameDao {

	public void save(RisultatoEsame esamiOffert);  // Create
	public RisultatoEsame findByPrimaryKey(Long id);     // Retrieve
	public List<RisultatoEsame> findAll();       
	public void update(RisultatoEsame esamiOffert); //Update
	public void delete(RisultatoEsame esamiOffert); //Delete
	
}
