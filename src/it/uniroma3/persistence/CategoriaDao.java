package it.uniroma3.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.uniroma3.model.Categoria;
import it.uniroma3.model.Tuto;

public class CategoriaDao implements DAO<Categoria>{

	private EntityManagerFactory emf;

	public CategoriaDao(EntityManagerFactory emf){
		this.emf = emf;
	}

	@Override
	public void save(Categoria categoria) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(categoria);
		tx.commit();
		em.close();		
	}

	@Override
	public void update(Categoria categoria) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(categoria);
		tx.commit();
		em.close();
	}

	@Override
	public Categoria findById(long id) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Categoria c = em.find(Categoria.class, id);
		tx.commit();
		em.close();
		return c;
	}

	@Override
	public void delete(Categoria categoria) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Categoria toRemove = em.merge(categoria);
		em.remove(toRemove);
		tx.commit();		
		em.close();		
	}

	@Override
	public List<Categoria> findAll() {
		EntityManager em = this.emf.createEntityManager();
		List<Categoria> result = em.createNamedQuery("Categoria.findAll").getResultList();
		em.close();
		return result;
	}
	/*
	@Override
	public List<Categoria> findByParameter(String parameter1, String column1, String parameter2, String column2) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();	
		
		Query query = em.createQuery("from Categoria t where t.c1=:p1 and t.c2=:p2");
		query.setParameter("p1", parameter1);
		query.setParameter("p2", parameter2);
		query.setParameter("c1", column1);
		query.setParameter("c2", column2);
		List<Categoria> list = query.getResultList();
		
		em.close();
		
		return list;
	}

	@Override
	public List<Categoria> findByParameter(String parameter, String column) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();	
		
		Query query = em.createQuery("from Categoria t where t.c=:p");
		query.setParameter("p", parameter);
		query.setParameter("c", column);
		List<Categoria> list = query.getResultList();
		
		em.close();
		
		return list;
	}
	*/

}
