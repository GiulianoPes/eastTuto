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
	@Column(unique = true)
	private String nome;
	@Column
	private String descrizione; 
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
	private List<Tuto> tuto;
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}	
}
