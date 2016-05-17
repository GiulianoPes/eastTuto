package it.uniroma3.persistence;

import java.util.List;

public interface DAO<T> {	
	public void save(T entity);	
	public void update(T entity);	
	public T findById(long id);	
	public void delete(T entity);	
	public List<T> findAll();
	public List<T> findByParameter(String parameter, String column);
	public List<T> findByParameter(String parameter1,String column1,String parameter2, String column2);
}