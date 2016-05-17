package it.uniroma3.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma3.dialog.Dialog;
import it.uniroma3.model.Utente;
import it.uniroma3.persistence.DAO;
import it.uniroma3.persistence.UtenteDao;

@WebServlet("/newUser")
public class NewUser extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("users-unit");
		UtenteDao utenteDao = new UtenteDao(emf);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Utente utente = new Utente(username,password);		
		
		utenteDao.save(utente);		
		
		//Si logga direttamente
		Utente u = utenteDao.findByCredentials(username, password);
		HttpSession session = request.getSession();
		session.setAttribute("Utente", u);
		request.setAttribute("Dialog", new Dialog("Login effettuato"));
		
		request.setAttribute("Utente", utente);
		request.setAttribute("Dialog", new Dialog("Registrazione avvenuta correttamente"));
		String nextPage = "/index.jsp";
		ServletContext application = getServletContext();		
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);		
		rd.forward(request, response);
	}

}
