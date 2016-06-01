package it.uniroma3.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import it.uniroma3.model.Utente;
import it.uniroma3.model.UtenteFacade;

@ManagedBean
@SessionScoped
public class SessionController{

	Utente utenteLogged;
	String username;
	String password;

	@EJB
	private UtenteFacade utenteFacade;

	public String login(){
		FacesContext context = FacesContext.getCurrentInstance();
		this.utenteLogged = utenteFacade.findByCredentials(username, password);

		if(this.utenteLogged != null){
			context.getExternalContext().getSessionMap().put("utenteLogged", utenteLogged);			
		}
		return "index";
	}
	public String logout(){
		FacesContext context = FacesContext.getCurrentInstance();
		this.utenteLogged = null;
		context.getExternalContext().getSessionMap().remove("utenteLogged");
		System.out.println("LOGOUT------------------------------");
		return "index";
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

	public Utente getUtente() {
		return utenteLogged;
	}

	public void setUtente(Utente utente) {
		this.utenteLogged = utente;
	}
}
