package it.uniroma3.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.uniroma3.model.Categoria;
import it.uniroma3.model.Tuto;
import it.uniroma3.model.Utente;

public class CategoriaDao implements DAO<Categoria>{

	private EntityManager em;

	public CategoriaDao(EntityManager em){
		this.em = em;
	}

	@Override
	public void save(Categoria categoria) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.persist(categoria);
		tx.commit();
		this.em.close();		
	}

	@Override
	public void update(Categoria categoria) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.merge(categoria);
		tx.commit();
		this.em.close();
	}

	@Override
	public Categoria findById(long id) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		Categoria c = this.em.find(Categoria.class, id);
		tx.commit();
		this.em.close();
		return c;
	}

	@Override
	public void delete(Categoria categoria) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		Categoria toRemove = this.em.merge(categoria);
		this.em.remove(toRemove);
		tx.commit();		
		this.em.close();		
	}

	@Override
	public List<Categoria> findAll() {
		List<Categoria> result = this.em.createNamedQuery("Categoria.findAll").getResultList();
		this.em.close();
		return result;
	}

	public Categoria findByName(String nomeCategoria){
		Categoria categoria = null;
		EntityTransaction tx = this.em.getTransaction();	

		Query query = this.em.createQuery("from Categoria c where c.nome=:p");
		query.setParameter("p", nomeCategoria);

		List<Categoria> list = query.getResultList();

		if(!list.isEmpty()){
			categoria = list.get(0);
		}
		
		this.em.close();			
		return categoria;
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
