package it.uniroma3.persistence;

import java.util.List;

import it.uniroma3.modelli.TipologiaEsame;

public interface TipologiaEsameDao {

	public void save(TipologiaEsame esamiOffert);  // Create
	public TipologiaEsame findByPrimaryKey(Long id);     // Retrieve
	public List<TipologiaEsame> findAll();       
	public void update(TipologiaEsame esamiOffert); //Update
	public void delete(TipologiaEsame esamiOffert); //Delete

}
