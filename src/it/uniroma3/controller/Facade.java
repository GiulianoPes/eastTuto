package it.uniroma3.controller;

import java.util.Date;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.uniroma3.model.Categoria;
import it.uniroma3.model.Tuto;
import it.uniroma3.model.Utente;
import it.uniroma3.persistence.CategoriaDao;
import it.uniroma3.persistence.DAO;
import it.uniroma3.persistence.TutoDao;
import it.uniroma3.persistence.UtenteDao;

public class Facade {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("users-unit");
	private static EntityManager em;

	// Login utente
	public static Utente Login(String username, String password) {
		em = emf.createEntityManager();
		UtenteDao utenteDao = new UtenteDao(em);
		Utente utente = utenteDao.findByCredentials(username, password);
		if (utente != null) {
			return utente;
		}else {
			return null;
		}
	}

	// Register a new User
	public static void addNewUser(Utente utente) {
		em = emf.createEntityManager();
		UtenteDao utenteDao = new UtenteDao(em);
		utenteDao.save(utente);
	}

	// Add new Tuto
	public static void addNewTuto(Tuto tuto) {
		em = emf.createEntityManager();
		DAO tutoDao = new TutoDao(em);
		tutoDao.save(tuto);
	}

	// get list of last tuto insert
	public static List<Tuto> getLastTuto() {
		em = emf.createEntityManager();
		TutoDao tutoDao = new TutoDao(em);
		return tutoDao.lastTuto();
	}

	public static Categoria getCategoria(String nomeCategoria){
		em = emf.createEntityManager();
		CategoriaDao categoriaDao = new CategoriaDao(em);
		return categoriaDao.findByName(nomeCategoria);
	}

	public static List<Tuto> getTutoFromUser(Utente utente) {
		em = emf.createEntityManager();
		UtenteDao utenteDao = new UtenteDao(em);
		return utenteDao.getTuto(utente);
	}

	public static Utente findUtenteByUsername(String username){
		em = emf.createEntityManager();
		UtenteDao utenteDao = new UtenteDao(em);
		Utente utente = utenteDao.findByUsername(username);
		if (utente != null) {
			return utente;
		}else {
			return null;
		}
	}

	public static void addFollowing(Utente currentUser, Utente following){
		em = emf.createEntityManager();
		UtenteDao utenteDao = new UtenteDao(em);
		currentUser.addFollowing(following);
		utenteDao.update(currentUser);
	}

	public static List<Categoria> getCategorie(){
		em = emf.createEntityManager();
		CategoriaDao categoriaDao = new CategoriaDao(em);
		return categoriaDao.getCategorie();
	}

	/*
	 * @Params tutoId (Long)
	 * @return Tuto
	 */
	public static Tuto getTutoFromId(Long tutoId) {
		em = emf.createEntityManager();
		TutoDao tutoDao = new TutoDao(em);
		return tutoDao.findById(tutoId);
	}

	public static boolean isFollowing(Utente utenteCorrente, Utente utentePagina){

		em = emf.createEntityManager();
		UtenteDao utenteDao = new UtenteDao(em);
		return utenteDao.isFollowing(utenteCorrente,utentePagina);

	}
	
	public List<Utente> getUtentiDb(){		
		em = emf.createEntityManager();
		UtenteDao utenteDao = new UtenteDao(em);
		return utenteDao.findAll();
	}

	public static void riempiDb(){
		
		//DAO Utente
		UtenteDao utenteDao,uD1,uD2,uD3,uD4;
		utenteDao = new UtenteDao(emf.createEntityManager());
		uD1 = new UtenteDao(emf.createEntityManager());
		uD2 = new UtenteDao(emf.createEntityManager());
		uD3 = new UtenteDao(emf.createEntityManager());
		uD4 = new UtenteDao(emf.createEntityManager());
		
		TutoDao tutoDao,tD1,tD2;
		tutoDao = new TutoDao(emf.createEntityManager());
		tD1 = new TutoDao(emf.createEntityManager());
		tD2 = new TutoDao(emf.createEntityManager());
		
		//Dao Tuto
		
		//Dao Categoria
		CategoriaDao categoriaDao,cD1,cD2,cD3; 
		categoriaDao = new CategoriaDao(emf.createEntityManager());
		cD1 = new CategoriaDao(emf.createEntityManager());
		cD2 = new CategoriaDao(emf.createEntityManager());
		cD3 = new CategoriaDao(emf.createEntityManager());
		
		
		

		//Creo gli oggetti
		Tuto tuto1 = new Tuto("JAVA", "A", new Date(System.currentTimeMillis()));
		Tuto tuto2 = new Tuto("SEGNALI", "B", new Date(System.currentTimeMillis()));
		Tuto tuto3 = new Tuto("PISTONI", "C", new Date(System.currentTimeMillis()));

		Utente utente1 = new Utente("Fabio", "f");
		Utente utente2 = new Utente("Giuliano", "g");
		Utente utente3 = new Utente("Vittorio", "v");
		/*
		Categoria categoria1 = new Categoria("INFORMATICA", "INF");
		Categoria categoria2 = new Categoria("ELETTRONICA", "ELE");
		Categoria categoria3 = new Categoria("MECCANICA", "MEC");
		Categoria categoria4 = new Categoria("MECCANICA QUANTISTICA", "MEC");
		
		categoriaDao.save(categoria1);
		cD1.save(categoria2);
		cD2.save(categoria3);
		cD3.save(categoria4);
		
		utenteDao.save(utente1);
		uD1.save(utente2);
		uD2.save(utente3);
		
		tuto1.setUtente(utente1);
		tuto1.setCategoria(categoria1);
		tutoDao.save(tuto1);
		tuto2.setUtente(utente2);
		tuto2.setCategoria(categoria2);
		tD1.save(tuto2);
		tuto3.setUtente(utente3);
		tuto3.setCategoria(categoria3);
		tD2.save(tuto3);
		
		utente1.addFollowing(utente2);//Fabio segue Giuliano
		utente2.addFollowing(utente3);//Giuliano segue Vittorio
		uD3.update(utente1);
		uD4.update(utente2);
		
		*/
		//Test (Non cancellare)
		/*
		utente1.addFollowing(utente2);//Fabio segue Giuliano;
		try{
			uD4.update(utente1);
		}catch(Exception e){
			System.out.println("Giusto");
		}*/
	}	
}