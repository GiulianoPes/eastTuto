package it.uniroma3.controller;

import java.io.IOException;
import java.util.Date;
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
import it.uniroma3.model.Categoria;
import it.uniroma3.model.Tuto;
import it.uniroma3.model.Utente;
import it.uniroma3.persistence.CategoriaDao;
import it.uniroma3.persistence.DAO;
import it.uniroma3.persistence.TutoDao;

@WebServlet("/addTuto")
public class AddTuto extends HttpServlet {
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("users-unit");
		
		DAO tutoDao = new TutoDao(emf);		
		
		//Creo categoria
		Categoria categoria = new Categoria();
		categoria.setNome(request.getParameter("categoria"));
		
		//Creo utente
		HttpSession session = request.getSession();
		Utente utente = (Utente) session.getAttribute("Utente");		
		
		//Creo il tuto
		Tuto tuto = new Tuto();
		tuto.setNome(request.getParameter("nome"));
		tuto.setDescrizione(request.getParameter("descrizione"));		
		//Setto gli utenti al tuto
		tuto.setCategoria(categoria);
		tuto.setUtente(utente);
		
		//Salvo il tutto nel Db
		tutoDao.update(tuto);		
		
		//Invio su showTuto.jsp il riepilogo del tuto
		request.setAttribute("Tuto",tuto);
		String nextPage = "/showTuto.jsp";		
		
		request.setAttribute("Dialog", new Dialog("Hai inserito il tuo tuto"));
		
		ServletContext application = getServletContext();		
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);		
		rd.forward(request,response);
	}
}
