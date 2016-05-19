package it.uniroma3.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.uniroma3.model.Categoria;
import it.uniroma3.model.Utente;

public class UtenteDao implements DAO<Utente>{

	EntityManagerFactory emf;

	public UtenteDao(EntityManagerFactory emf){
		this.emf = emf;
	}

	@Override
	public void save(Utente utente) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(utente);
		tx.commit();
		em.close();		
	}

	@Override
	public void update(Utente utente) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(utente);
		tx.commit();
		em.close();
	}

	@Override
	public Utente findById(long id) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Utente u = em.find(Utente.class, id);
		tx.commit();
		em.close();
		return u;
	}

	@Override
	public void delete(Utente utente) {

		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Utente toRemove = em.merge(utente);
		em.remove(toRemove);
		tx.commit();		
		em.close();

	}

	@Override
	public List<Utente> findAll() {
		EntityManager em = this.emf.createEntityManager();
		List<Utente> result = em.createNamedQuery("Utente.findAll").getResultList();
		em.close();
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
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();	
		
		Query query = em.createQuery("from Utente u where u.username=:u and u.password=:p");
		query.setParameter("u", username);
		query.setParameter("p", password);

		List<Utente> list = query.getResultList();
		
		if(!list.isEmpty()){
			utente = list.get(0);
		}
		em.close();		
		return utente;
	}
	
	public List<Utente> getFollowingByUtente(Utente utente){		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();	
		/*
		Query query = em.createQuery("from utente join utente as u where u.utente_id=:id ");
		query.setParameter("id", utente.getId());
		query.getResultList().toString();
		*/
		//List<Utente> following = utente.getFollowing();
		List<Utente> following = new ArrayList<Utente>();
		
		em.close();
		
		return following;
	}
}
