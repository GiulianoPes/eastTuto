package it.uniroma3.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.model.Tuto;
import it.uniroma3.model.TutoFacade;

@ManagedBean
public class TutoController{
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String nome;
	private String descrizione;
	private Date dataCreazione;
	
	private Tuto tuto;
	private List<Tuto> tutos;
	
	@EJB
	private TutoFacade tutoFacade;
	
	public Tuto creaTuto() {
		this.dataCreazione = new Date(System.currentTimeMillis());
		this.tuto = tutoFacade.save(nome, descrizione, dataCreazione);
		return this.tuto; 
	}
	
	

}
