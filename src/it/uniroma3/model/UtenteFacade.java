package it.uniroma3.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

@Stateless
public class UtenteFacade{
	
	@PersistenceContext(unitName = "easyTuto")
    private EntityManager em;
	
	public Utente save(Utente utente) {
		em.persist(utente);
		utente = this.findByCredentials(utente.getUsername(), utente.getPassword());
		return utente;
	}
	public Utente save(String username, String password) {
		Utente utente = new Utente(username,password);
		em.persist(utente);
		return utente;
	}

	public Utente update(Utente utente){
		em.merge(utente);
		return utente;
	}

	public Utente findById(long id) {
		Utente utente = em.find(Utente.class, id);
		return utente;
	}

	public void delete(Utente utente) {
		Utente toRemove = em.merge(utente);
		em.remove(toRemove);
	}

	public List<Utente> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Utente> cq = cb.createQuery(Utente.class);
		Root<Utente> rootCategoria = cq.from(Utente.class);
		System.out.println(cb+" - "+cq);
		System.out.println(rootCategoria);
		System.out.println("prima");
        List<Utente> result = em.createQuery(cq).getResultList();
        System.out.println("dopo");
		return result;
	}
	
	public Utente findByCredentials(String username, String password){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Utente> cq = cb.createQuery(Utente.class);	
		Root<Utente> rootUtenti = cq.from(Utente.class);
		ParameterExpression<String> parameter = cb.parameter(String.class);
		parameter.alias(username);
        cq.where(cb.equal(rootUtenti.get("username"), username),cb.equal(rootUtenti.get("password"), password));
        List<Utente> list = em.createQuery(cq).getResultList();
        
        Utente utente = null;
        if(!list.isEmpty()){
			utente = list.get(0);
		}
		return utente; 
	}
	public Utente findByUsername(String username){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Utente> cq = cb.createQuery(Utente.class);	
		Root<Utente> rootUtenti = cq.from(Utente.class);
		ParameterExpression<String> parameter = cb.parameter(String.class);
		parameter.alias(username);
        cq.where(cb.equal(rootUtenti.get("username"), username));
        List<Utente> list = em.createQuery(cq).getResultList();
        
        Utente utente = null;
        if(!list.isEmpty()){
			utente = list.get(0);
		}
		return utente; 
	}
	public List<Utente> getFollowing(Utente utente){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Utente> cq = cb.createQuery(Utente.class);//Riporta dei tuto
		Root rootUtente = cq.from(Utente.class);//Tabella dei tuto
		
		/*
		ParameterExpression<Long> parameter = cb.parameter(Long.class);//
		parameter.alias(utente.getId().toString());       
		*/
		cq.where(cb.equal(rootUtente.get("utente"), utente));
		List<Utente> following = em.createQuery(cq).getResultList();
		
		return following;
	}
}