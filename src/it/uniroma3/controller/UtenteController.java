package it.uniroma3.controller;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.model.Utente;
import it.uniroma3.model.UtenteFacade;

@ManagedBean
public class UtenteController{
	
	
	@ManagedProperty(value="#{param.id}")
	private Long id;	
	private String username;
	private String password;	
	
	private Utente utente;
	
	private Long idUtente;
	private Long idUtenteDaSeguire;
	
	@ManagedProperty(value="#{sessionController}")
	private SessionController sessionController;
	
	private List<Utente> utenti;
	private List<Utente> following;
	
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
	
	public double getTotalMoneyFromTuto() {
		return this.utente.getTotalMoney();
	}
	
	/*
	public String myProfile(Long id){
		this.utente = utenteFacade.findById(id);
		return "profilePage.jsp";
	}
	*/
	public Utente myProfile(String username){
		System.out.println("CHIAMATA A MYPROFILE: "+username);
		this.utente = utenteFacade.findByUsername(username);
		System.out.println("Chiamata a myProfile "+username);
		if(this.utente!=null){
		System.out.println(utente.getTuto().size());
		System.out.println(utente.getFollowing().size());}
		return this.utente;
	}
	public List<Utente> getFollowFromUtente(Utente utente){
		this.following = utenteFacade.getFollowing(this.utente);
		return this.following;
	}

	public void addFollowing() {
		System.out.println("---------SONO ENTRATO ----------");
		System.out.println("--------VEDIAMO L'UTENTE --------");
		//System.out.println("UTENTE: " + idUtente);
		//System.out.println("UTENTE DA SEGUIRE :" + idUtenteDaSeguire);
		//utenteLoggato.addFollowing(utenteDaSeguire);
		//utenteFacade.update(utenteLoggato);
	}
	
	/*
	public String addFollowing(){
		//System.out.println("chiamo sesssion controller add following "+this.utente.getUsername());
		this.sessionController.addFollowing(this.utente);
		return "Following";
	}
	
	public String addFollowing(String following){
		this.utente = this.myProfile(following);
		//System.out.println("chiamo sesssion controller add following "+this.utente.getUsername());
		this.sessionController.addFollowing(this.utente);
		return "Following";
	}
	*/
	
	
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

	public List<Utente> getFollowing() {
		return following;
	}

	public void setFollowing(List<Utente> following) {
		this.following = following;
	}


	
}