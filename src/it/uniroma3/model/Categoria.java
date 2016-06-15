package it.uniroma3.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	@Column(unique = true)
	private String nome;
	
	//Una categoria pu� appartenere a molti tuto
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    //@JoinColumn(name = "categoria_id")
	private List<Tuto> tuto;
	
	@Column(unique = true)
	private String descrizione;
	
	@Column(unique = true)
	private String immagine;

	public Categoria(){
		this.tuto = new ArrayList<>();
	}
	
	public Categoria(String nome){
		this.nome = nome;
		this.tuto = new ArrayList<>();
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
	
	public List<Tuto> getTuto() {
		return tuto;
	}

	public void setTuto(List<Tuto> tuto) {
		this.tuto = tuto;
	}
	
	public void addTuto(Tuto tuto){
		this.tuto.add(tuto);
	}
	
	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	//Se inserito, non carica le categorie quando si vuole compilare un tuto.
	/*
	public boolean equals(Object obj) {
		Categoria c = (Categoria) obj;
		System.out.println(this+" - "+c);
		return this.getNome().equals(c.getNome());
	}	
	*/
	
	
	public String toString(){
		return this.getNome();
	}
}
