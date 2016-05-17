package it.uniroma3.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.uniroma3.model.Categoria;
import it.uniroma3.model.Tuto;
import it.uniroma3.model.Utente;

public class TutoDao implements DAO<Tuto>{

	EntityManagerFactory emf;

	public TutoDao(EntityManagerFactory emf){
		this.emf = emf;
	}

	@Override
	public void save(Tuto tuto){
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(tuto);
		tx.commit();
		em.close();
	}

	@Override
	public void update(Tuto tuto) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(tuto);
		tx.commit();
		em.close();
	}

	@Override
	public Tuto findById(long id) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Tuto t = em.find(Tuto.class, id);
		tx.commit();
		em.close();
		return t;
	}

	@Override
	public void delete(Tuto tuto) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Tuto toRemove = em.merge(tuto);
		em.remove(toRemove);
		tx.commit();		
		em.close();
	}

	@Override
	public List<Tuto> findAll() {
		EntityManager em = this.emf.createEntityManager();
		List<Tuto> result = em.createNamedQuery("Tuto.findAll").getResultList();
		em.close();
		return result;
	}

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
}
