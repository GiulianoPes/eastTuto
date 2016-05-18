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
import it.uniroma3.model.Tuto;
import it.uniroma3.model.Utente;
import it.uniroma3.persistence.DAO;
import it.uniroma3.persistence.TutoDao;
import it.uniroma3.persistence.UtenteDao;

@WebServlet("/viewMyTuto")
public class ViewMyTuto extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("users-unit");
		HttpSession session = request.getSession();
		
		Utente utente = (Utente)session.getAttribute("Utente");
		
		TutoDao tutoDao = new TutoDao(emf);
		List<Tuto> listaTuto = tutoDao.findTutoByUtente(utente);
		request.setAttribute("listaTuto", listaTuto);
		
		String nextPage = "/myTuto.jsp";
		ServletContext application = getServletContext();		
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);		
		rd.forward(request,response);
	}
}
