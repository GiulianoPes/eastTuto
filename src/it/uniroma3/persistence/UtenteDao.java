package it.uniroma3.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.uniroma3.model.Tuto;
import it.uniroma3.model.Utente;

public class UtenteDao implements DAO<Utente>{

	private EntityManager em;
	
	public UtenteDao(EntityManager em){
		this.em = em;
	}

	@Override
	public void save(Utente utente) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.persist(utente);
		tx.commit();
		this.em.close();		
	}

	@Override
	public void update(Utente utente) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.merge(utente);
		tx.commit();
		this.em.close();
	}
	
	public Utente findByUsername(String username) {
		Utente utente = null;	
		
		//Query query = this.em.createQuery("from Utente u where u.username=:u and u.password=:p");
		Query query = this.em.createQuery("from Utente u where u.username=:u");
		query.setParameter("u", username);
		//query.setParameter("p", "v");

		List<Utente> list = query.getResultList();
		
		if(!list.isEmpty()){
			utente = list.get(0);
		}
		
		this.em.close();		
		return utente;
	}

	@Override
	public Utente findById(long id) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		Utente u = this.em.find(Utente.class, id);
		tx.commit();
		this.em.close();
		return u;
	}

	@Override
	public void delete(Utente utente) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		Utente toRemove = this.em.merge(utente);
		this.em.remove(toRemove);
		tx.commit();		
		this.em.close();

	}

	@Override
	public List<Utente> findAll() {
		List<Utente> result = em.createNamedQuery("Utente.findAll").getResultList();
		this.em.close();
		return result;
	}

	/*
	@Override
	public List<Utente> findByParameter(String parameter1, String column1, String parameter2, String column2) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();	
		
		Query query = em.createQuery("from Utente u where u.username=:p1 and u.password=:p2");
		//query.setParameter("c1", column1);
		query.setParameter("p1", parameter1);
		//query.setParameter("c2", column2);
		query.setParameter("p2", parameter2);
		/*
		Query query = em.createQuery("from Utente u where u. ?4=?3 and u. ?2=?1");
		query.setParameter(4, column1); 
		query.setParameter(3, parameter1); 
		query.setParameter(2, column2); 
		query.setParameter(1, parameter2);
	
		List<Utente> list = query.getResultList();
		
		em.close();
		
		return list;
	}
	

	@Override
	public List<Utente> findByParameter(String parameter, String column) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();	
		
		Query query = em.createQuery("from Categoria t where t.c=:p");
		query.setParameter("p", parameter);
		query.setParameter("c", column);
		List<Utente> list = query.getResultList();
		
		em.close();
		
		return list;
	}
	*/
	
	public Utente findByCredentials(String username, String password){
		Utente utente = null;
		EntityTransaction tx = this.em.getTransaction();	
		
		Query query = this.em.createQuery("from Utente u where u.username=:u and u.password=:p");
		query.setParameter("u", username);
		query.setParameter("p", password);

		List<Utente> list = query.getResultList();
		
		if(!list.isEmpty()){
			utente = list.get(0);
		}
		this.em.close();		
		return utente;
	}
	
	public List<Utente> getFollowingByUtente(Utente utente){		
		EntityTransaction tx = this.em.getTransaction();	
		List<Utente> following = new ArrayList<Utente>();
		this.em.close();
		return following;
	}
	
	public List<Tuto> getTuto(Utente utente) {	
		
		Query query = this.em.createQuery("from Tuto t where t.utente_id=:id");
		query.setParameter("id", utente.getId());
		List<Tuto> listTuto = query.getResultList();
		
		this.em.close();		
		return listTuto;
	}
}
