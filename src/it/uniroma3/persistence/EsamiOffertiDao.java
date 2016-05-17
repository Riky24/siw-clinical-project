package it.uniroma3.persistence;

import java.util.List;
import it.uniroma3.modelli.EsamiOfferti;

public class EsamiOffertiDao {

	public void save(EsamiOfferti esameOfferto);  // Create
	public EsamiOfferti findByPrimaryKey(String nome);     // Retrieve
	public List<EsameOfferti> findAll();       
	public void update(EsamiOfferti esameOfferto); //Update
	public void delete(EsamiOfferti esameOfferto); //Delete
	
}
