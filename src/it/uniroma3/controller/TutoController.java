package it.uniroma3.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import it.uniroma3.model.Categoria;
import it.uniroma3.model.CategoriaFacade;
import it.uniroma3.model.Tuto;
import it.uniroma3.model.TutoFacade;
import it.uniroma3.model.Utente;

@ManagedBean
public class TutoController{
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String nome;
	private String descrizione;
	private Date dataCreazione;
	
	private String categoriaNome;	
	private Categoria categoria;
	private Utente utente;
	
	private int visualizzazioni;
	
	private Tuto tuto;
	private List<Tuto> tutos;
	
	private double money;
	
	@EJB
	private TutoFacade tutoFacade;
	@EJB
	private CategoriaFacade categoriaFacade;
	
	public String creaTuto() {
		System.out.println("---------------------"+categoriaNome);
		this.dataCreazione = new Date(System.currentTimeMillis());
		
		this.categoria = categoriaFacade.findByName(categoriaNome);
		System.out.println(this.categoria);
		
		//Creao il tuto
		this.tuto = new Tuto();
		this.tuto.setNome(nome);
		this.tuto.setDescrizione(descrizione);
		this.tuto.setDataCreazione(dataCreazione);
		this.tuto.setCategoria(this.categoria);
		//Utente in sessione
		FacesContext context = FacesContext.getCurrentInstance();
		this.utente = (Utente) context.getExternalContext().getSessionMap().get("utenteLogged");
		this.tuto.setUtente(utente);
		//Lo salvo
		this.tuto = tutoFacade.save(this.tuto);
		System.out.println("Finito di creare");
		return "index.xhtml"; 
	}

	public String modificaTuto() {
		System.out.println("SONO ENTRATO IN MODIFCA: ");
		
		this.dataCreazione = new Date(System.currentTimeMillis());
		
		this.categoria = categoriaFacade.findByName(categoriaNome);
		
		//Creao il tuto
		this.tuto = new Tuto();
		System.out.println("NOME: " + nome + " - DESCRIZIONE: " + descrizione);
		this.tuto.setId(id);
		this.tuto.setNome(nome);
		this.tuto.setDescrizione(descrizione);
		this.tuto.setVisualizzazioni(visualizzazioni);
		this.tuto.setDataCreazione(dataCreazione);
		this.tuto.setCategoria(this.categoria);
		
		//Utente in sessione
		FacesContext context = FacesContext.getCurrentInstance();
		this.utente = (Utente) context.getExternalContext().getSessionMap().get("utenteLogged");
		this.tuto.setUtente(utente);
		
		//Lo modifico
		tutoFacade.update(this.tuto);
		//this.tuto = tutoFacade.update(this.tuto);
		System.out.println("Finito di modificare");
		return "index.xhtml"; 
	}
	
	public String eliminaTuto() {
		System.out.println("------SONO NELL ELIMINA ------");
		System.out.println("ID: " + this.tuto);
		//this.tuto = tutoFacade.findById(id);
		//tutoFacade.delete(this.tuto);
		return "index.xhtml";
	}
	
	public double getMoneyFromTutoForUser(Tuto tuto) {
		double money;
		// 1000 visualizzazioni = 1 €
		money = (tuto.getVisualizzazioni()/1000)*0.1;
		return money;
	}
	
	public int aggiungiVisualizzazione(Tuto tuto) {
		System.out.println("------SONO DENTRO AGGIUNGI VISUALIZZAZIONE---------");

		int visualizzazioni = tuto.getVisualizzazioni();
		visualizzazioni++;
		tuto.setVisualizzazioni(visualizzazioni);
		
		tutoFacade.update(tuto);
		
		return tuto.getVisualizzazioni();
	}
	
	public double getMoneyFromTutoForEasyTuto(Tuto tuto) {
		double money;
		// 1000 visualizzazioni = 1 €
		money = (tuto.getVisualizzazioni()/1000);
		return money;
	}
	
	public List<Tuto> initTuto(){
		this.tutos = tutoFacade.findAll();
		System.out.println(this.tutos.toString());
		//return this.tutos;
		return this.tutos;
	}
	
	public String getTutoFromUtente(){
		this.tutos = tutoFacade.getTutoFromUtente(this.utente);
		return "tutos";
	}
	public List<Tuto> getTutoFromUtente(Utente utente){
		this.tutos = tutoFacade.getTutoFromUtente(utente);
		System.out.println("I tuto di "+utente.getUsername());
		return this.tutos;
	}
	public Tuto getTutoFromId(Long id) {
		this.tuto = tutoFacade.findById(id);
		return tuto;
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

		
	public String getCategoriaNome(){
		return this.categoriaNome;
	}
	
	public void setCategoriaNome(String categoriaNome){
		this.categoriaNome = categoriaNome;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Tuto getTuto() {
		return tuto;
	}

	public void setTuto(Tuto tuto) {
		this.tuto = tuto;
	}

	public List<Tuto> getTutos() {
		return tutos;
	}

	public void setTutos(List<Tuto> tutos) {
		this.tutos = tutos;
	}

	public TutoFacade getTutoFacade() {
		return tutoFacade;
	}

	public void setTutoFacade(TutoFacade tutoFacade) {
		this.tutoFacade = tutoFacade;
	}
	
	public void setVisualizzazioni(int visualizzazioni) {
		this.visualizzazioni = visualizzazioni;
	}
	
	public int getVisualizzazioni() {
		return this.visualizzazioni;
	}
}
