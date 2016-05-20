package it.uniroma3.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.uniroma3.model.Categoria;
import it.uniroma3.model.Tuto;
import it.uniroma3.model.Utente;

public class TutoDao implements DAO<Tuto>{

	private EntityManager em;

	public TutoDao(EntityManager em){
		this.em = em;
	}

	@Override
	public void save(Tuto tuto){
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.persist(tuto);
		tx.commit();
		this.em.close();
	}

	@Override
	public void update(Tuto tuto) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.merge(tuto);
		tx.commit();
		this.em.close();
	}

	@Override
	public Tuto findById(long id) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		Tuto t = this.em.find(Tuto.class, id);
		tx.commit();
		this.em.close();
		return t;
	}

	@Override
	public void delete(Tuto tuto) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		Tuto toRemove = this.em.merge(tuto);
		this.em.remove(toRemove);
		tx.commit();		
		this.em.close();
	}

	@Override
	public List<Tuto> findAll() {
		List<Tuto> result = this.em.createNamedQuery("Tuto.findAll").getResultList();
		this.em.close();
		return result;
	}

	/*
	@Override
	public List<Tuto> findByParameter(String parameter1, String column1, String parameter2, String column2) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();	
		
		Query query = em.createQuery("from Tuto t where t.c1=:p1 and t.c2=:p2");
		query.setParameter("p1", parameter1);
		query.setParameter("p2", parameter2);
		query.setParameter("c1", column1);
		query.setParameter("c2", column2);
		List<Tuto> list = query.getResultList();
		
		em.close();
		
		return list;
	}

	@Override
	public List<Tuto> findByParameter(String parameter, String column) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();	
		
		Query query = em.createQuery("from Categoria t where t.c=:p");
		query.setParameter("p", parameter);
		query.setParameter("c", column);
		List<Tuto> list = query.getResultList();
		
		em.close();
		
		return list;
	}
	*/
	
	public List<Tuto> findTutoByUtente(Utente utente){
		EntityTransaction tx = this.em.getTransaction();	
		
		Query query = this.em.createQuery("from Tuto t where t.utente_id=:p");
		query.setParameter("p", utente.getId());
		List<Tuto> listaTuto = query.getResultList();
				
		this.em.close();		
		return listaTuto;
	}
	
	public List<Tuto> lastTuto(){
		List<Tuto> lastTuto=null;
		EntityTransaction tx = this.em.getTransaction();	
		
		Query query = this.em.createQuery("from Tuto t ORDER BY t.dataCreazione ASC");
		lastTuto = query.getResultList();
				
		this.em.close();		
		return lastTuto;
	}
	
	public List<Tuto> findTutoByCategoria(String nomeCategoria){
		EntityTransaction tx = this.em.getTransaction();
		CategoriaDao categoriaDao = new CategoriaDao(em);
		Categoria categoria = categoriaDao.findByName(nomeCategoria);
		
		Query query = this.em.createQuery("from Categoria c where c.categoria_id=:p");
		query.setParameter("p", categoria.getId());
		List<Tuto> categorie = query.getResultList();
				
		this.em.close();		
		return categorie;
	}
}
