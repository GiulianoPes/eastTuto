package it.uniroma3.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class CategoriaFacade {

	@PersistenceContext(unitName = "easyTuto")
	private EntityManager em;

	public Categoria save(Categoria categoria) {
		em.persist(categoria);
		return categoria;
	}

	public void update(Categoria categoria) {
		em.merge(categoria);
	}

	public Categoria findById(long id) {
		Categoria categoria = em.find(Categoria.class, id);
		return categoria;
	}

	public void delete(Categoria categoria) {
		//Categoria toRemove = 
		em.merge(categoria);
	}

	public List<Categoria> findAll() {
		CriteriaQuery<Categoria> cq = em.getCriteriaBuilder().createQuery(Categoria.class);
		cq.select(cq.from(Categoria.class));
		List<Categoria> categorie = em.createQuery(cq).getResultList();
		return categorie;
	}

	public Categoria findByName(String nomeCategoria){		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Categoria> cq = cb.createQuery(Categoria.class);	
		Root<Categoria> root = cq.from(Categoria.class);
		cq.where(cb.equal(root.get("nome"), nomeCategoria));
		List<Categoria> result = em.createQuery(cq).getResultList();        
		Categoria categoria = result.get(0);
		return categoria;
	}
}
