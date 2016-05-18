package it.uniroma3.persistence;

import java.util.List;

public interface Dao<T> {
	
	public void save(T entity);
	
	public void update(T entity);
	
	public T findById(long id);
	
	public void delete(T entity);
	
	public List<T> findAll();

}
