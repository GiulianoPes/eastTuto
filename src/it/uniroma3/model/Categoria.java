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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	@Column
	private String nome;
	@Column
	private String descrizione; 

	@OneToMany(cascade = {CascadeType.ALL},fetch= FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
	private List<Tuto> tuto;
	
	@OneToMany(cascade = {CascadeType.ALL},fetch= FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
	private List<Utente> utenti;
	
	public Categoria(){
		this.tuto = new ArrayList<>();
	}
	
	public Categoria(String nome, String descrizione){
		this.nome = nome;
		this.descrizione = descrizione;
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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
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
}
