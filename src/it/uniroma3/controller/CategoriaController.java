package it.uniroma3.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.model.Categoria;
import it.uniroma3.model.CategoriaFacade;
import it.uniroma3.model.Tuto;

@ManagedBean
public class CategoriaController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String nome;
	private String descrizione;
	
	private Categoria categoria;
	private List<Categoria> categorie;
	
	@EJB
	private CategoriaFacade categoriaFacade;
	
	public Categoria creaCategoria(){
		Categoria categoria = new Categoria(nome);
		this.categoria = categoriaFacade.save(categoria);
		return this.categoria; 
	}
	
	public List<Categoria> getCategorie(){
		this.categorie = categoriaFacade.findAll();
		return this.categorie;
	}
	

}
