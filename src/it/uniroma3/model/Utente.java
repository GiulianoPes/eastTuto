package it.uniroma3.model;

import java.lang.annotation.Repeatable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.mapping.PrimaryKey;

import com.oracle.webservices.internal.api.message.PropertySet.Property;
import com.sun.org.glassfish.gmbal.NameValue;

@Entity
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "utente_id")
	private List<Tuto> tuto;
	
	//Following
	@ManyToMany(cascade = {CascadeType.DETACH}, fetch = FetchType.EAGER)
	@JoinTable(name = "utenteSegue")
	@JoinColumn(name = "utente_id", referencedColumnName = "id")
	private Set<Utente> following;
	
	public Utente(){
		this.tuto = new ArrayList<>();
		this.following = new HashSet<>(); 
	}
	
	public Utente(String username,String password){
		this.username = username;
		this.password = password;
		this.tuto = new ArrayList<>();
		this.following = new HashSet<>(); 
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
	
	//Lista dei Tuto
	public void addTuto(Tuto tuto){
		this.tuto.add(tuto);
	}	

	public List<Tuto> getTuto() {
		return this.tuto;
	}
	
	public void setTuto(List<Tuto> listTuto) {
		this.tuto = listTuto;
	}
	
	public void addFollowing(Utente utente){
		this.following.add(utente);
	}

	public Set<Utente> getFollowing() {
		return following;
	}

	public void setFollowing(Set<Utente> following) {
		this.following = following;
	}
	
	public boolean isFollowing(Utente utente){
		return this.following.contains(utente);
	}	
	
	public String toString(){
		return this.getId()+" - "+this.getUsername();
	}

	@Override
	public int hashCode() {
		return this.getId().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Utente utente = (Utente) obj;
		return this.getId().equals(utente.getId());
	}	
}
