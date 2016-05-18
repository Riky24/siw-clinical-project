package it.uniroma3.persistence;

import java.util.List;

import it.uniroma3.modelli.EsamiOfferti;

public interface EsamiOffertiDao {

	public void save(EsamiOfferti esamiOffert);  // Create
	public EsamiOfferti findByPrimaryKey(Long id);     // Retrieve
	public List<EsamiOfferti> findAll();       
	public void update(EsamiOfferti esamiOffert); //Update
	public void delete(EsamiOfferti esamiOffert); //Delete

}
