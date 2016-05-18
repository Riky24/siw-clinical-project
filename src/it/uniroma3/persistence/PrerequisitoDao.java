package it.uniroma3.persistence;

import java.util.List;

import it.uniroma3.modelli.Prerequisito;

public interface PrerequisitoDao {

	public void save(Prerequisito prerequisito);  // Create
	public Prerequisito findByPrimaryKey(Long id);     // Retrieve
	public List<Prerequisito> findAll();       
	public void update(Prerequisito prerequisito); //Update
	public void delete(Prerequisito prerequisito); //Delete

}
