package it.uniroma3.controller;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;

import it.uniroma3.model.Utente;
import it.uniroma3.model.UtenteFacade;

@ManagedBean
public class UtenteController{
	
	
	@ManagedProperty(value="#{param.id}")
	private Long id;	
	private String username;
	private String password;	
	
	private Utente utente;
	@ManagedProperty(value="#{sessionController}")
	private SessionController sessionController;
	private List<Utente> utenti;
	
	@EJB
	private UtenteFacade utenteFacade;
	
	public String register(){		
		utenteFacade.save(username, password);
		this.utente = utenteFacade.findByCredentials(username, password);
		if(this.utente != null){
			sessionController.setPassword(password);
			sessionController.setUsername(username);
			sessionController.login();
		}
		return "index.xhtml";
	}
	
	public List<Utente> getUtenti(){
		this.utenti = utenteFacade.findAll();
		return this.utenti;
	}
	
	public String myProfile(Long id){
		this.utente = utenteFacade.findById(id);
		return "profilePage.jsp";
	}
	
	//Getter and setter

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

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public UtenteFacade getUtenteFacade() {
		return utenteFacade;
	}
	

	public SessionController getSessionController() {
		return sessionController;
	}

	public void setSessionController(SessionController sessionController) {
		this.sessionController = sessionController;
	}

	public void setUtenteFacade(UtenteFacade utenteFacade) {
		this.utenteFacade = utenteFacade;
	}

	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}


	
}