package it.uniroma3.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.uniroma3.model.Tuto;
import it.uniroma3.model.Utente;
import it.uniroma3.persistence.DAO;
import it.uniroma3.persistence.TutoDao;
import it.uniroma3.persistence.UtenteDao;

public class Facade {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("users-unit");
	//private static EntityManager em = emf.createEntityManager();
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
		tutoDao.update(tuto);
	}
	
	// get list of last tuto insert
	public static List<Tuto> getLastTuto() {
		em = emf.createEntityManager();
		TutoDao tutoDao = new TutoDao(em);
		return tutoDao.lastTuto();
	}
}