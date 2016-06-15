package it.uniroma3.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import it.uniroma3.model.Categoria;
import it.uniroma3.model.CategoriaFacade;

@ManagedBean
public class CategoriaController {
	
	@ManagedProperty(value="#{param.categoryId}")
	private Long id;
	private String nome;
	
	private Categoria categoria;
	private List<Categoria> categorie;
	
	@EJB
	private CategoriaFacade categoriaFacade;
	
	public Categoria findById(Long id){
		return categoriaFacade.findById(id); 
	}
	
	public Categoria creaCategoria(){
		Categoria categoria = new Categoria(nome);
		this.categoria = categoriaFacade.save(categoria);
		return this.categoria; 
	}
	
	public String initCategorie(){
		this.categorie = categoriaFacade.findAll();
		System.out.println(this.categorie.toString());
		return "compileTuto.jsp";
	}
	
	public void set8Categorie(){
		List<Categoria> categorie = categoriaFacade.findAll();
		Iterator<Categoria> iterator = categorie.iterator();
		
		this.categorie = new ArrayList<Categoria>();		
		int i=0;
		while((i<8) && (iterator.hasNext())){
			this.categorie.add(iterator.next());
		}
		
		System.out.println(this.categorie);
		//return this.categorie;
	}
	
	public List<Categoria> inizializzaCategorie() {
		this.categorie = categoriaFacade.findAll();
		return this.categorie;
	}
	
	public List<Categoria> getCategorie(){
		return this.categorie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setCategorie(List<Categoria> categorie) {
		this.categorie = categorie;
	}

	/*
	public List<String> getListaNomiCategorie() {
		return listaNomiCategorie;
	}

	public void setListaNomiCategorie(List<String> listaNomiCategorie) {
		this.listaNomiCategorie = listaNomiCategorie;
	}	
	*/
}
