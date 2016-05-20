package it.uniroma3.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Tuto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	
	@Column(nullable = false)
	private String nome; 
	
	@Column
	private String descrizione;
	
	@Temporal(TemporalType.DATE)
    private Date dataCreazione;
	
	@ManyToOne(cascade = {CascadeType.DETACH} ,fetch = FetchType.EAGER)
    @JoinColumn(name = "utente_id", referencedColumnName = "id")
	private Utente utente;	
	
	@ManyToOne(cascade = {CascadeType.DETACH} ,fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
	private Categoria categoria;

	public Tuto(){}
	
	public Tuto(String nome, String descrizione, Date dataCreazione){
		this.nome = nome;
		this.descrizione =  descrizione;
		this.dataCreazione = dataCreazione;
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

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	
	public Utente getUtente(){
		return this.utente;
	}

	public void setUtente(Utente utente){
		this.utente = utente;
	}
	
	public Categoria getCategoria(){
		return this.categoria;
	}
	
	public void setCategoria(Categoria categoria){
		this.categoria = categoria;
	}
}
