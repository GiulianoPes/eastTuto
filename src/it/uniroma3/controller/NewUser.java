package it.uniroma3.controller;

import java.io.IOException;

import javax.persistence.PersistenceException;
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

@WebServlet("/newUser")
public class NewUser extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{

		//Facade facade = new Facade();
		HttpSession session = request.getSession();
		
		String nextPage = "";
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Utente utente = new Utente(username,password);
		try {
			Facade.addNewUser(utente);
			session.setAttribute("Utente", utente);
			request.setAttribute("Dialog", new Dialog("Registrazione avvenuta correttamente"));
			nextPage = "/index.jsp";
		} catch(PersistenceException e) {
			request.setAttribute("Utente", null);
			request.setAttribute("Dialog", new Dialog("Username non disponibile"));
			nextPage = "/register.jsp";
		}
		
		
		
		ServletContext application = getServletContext();		
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);		
		rd.forward(request, response);
	}

}
