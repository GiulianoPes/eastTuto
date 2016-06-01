package it.uniroma3.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	public Utente save(String username, String passwort) {
		Utente utente = new Utente(username,passwort);
		//utente.setId(2L);
		em.persist(utente);
		//utente = this.findByCredentials(utente.getUsername(), utente.getPassword());
		return utente;
	}

	public void update(Utente utente){
		em.merge(utente);
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
		List<Utente> result = em.createNamedQuery("Utente.findAll").getResultList();
		return result;
	}
	
	public Utente findByCredentials(String username, String password){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Utente> cq = cb.createQuery(Utente.class);	
		Root rootUtenti = cq.from(Utente.class);
		ParameterExpression<String> parameter = cb.parameter(String.class);
		parameter.alias(username);
        //cq.select(rootUtenti).where(cb.gt(rootUtenti.get("username"), parameter));
        cq.where(cb.equal(rootUtenti.get("username"), username),cb.equal(rootUtenti.get("password"), password));
        List<Utente> list = em.createQuery(cq).getResultList();
        Utente utente = null;
        if(!list.isEmpty()){
			utente = list.get(0);
		}
		return utente; 
		/*
		Utente utente = null;		
		Query query = em.createQuery("from Utente u where u.username=:u and u.password=:p");
		query.setParameter("u", username);
		query.setParameter("p", password);

		List<Utente> list = query.getResultList();
		
		if(!list.isEmpty()){
			utente = list.get(0);
		}
		return utente;
		*/
	}
}