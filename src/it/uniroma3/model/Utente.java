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

@Entity
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@OneToMany(cascade = {CascadeType.ALL},fetch= FetchType.EAGER)
    @JoinColumn(name = "utente_id")
	private List<Tuto> tuto;

	@OneToMany(cascade = {CascadeType.ALL},fetch= FetchType.EAGER)
    @JoinColumn(name = "utente_id")
	private List<Categoria> categorie;

	public Utente(){
		this.tuto = new ArrayList<>();
	}
	
	public Utente(String username,String password){
		this.username = username;
		this.password = password;
		this.tuto = new ArrayList<>();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addTuto(Tuto tuto){
		this.tuto.add(tuto);
	}
	
	public List<Tuto> getTuto() {
		return tuto;
	}

	public void setTuto(List<Tuto> tuto) {
		this.tuto = tuto;
	}
}
