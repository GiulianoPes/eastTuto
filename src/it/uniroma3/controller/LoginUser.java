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
import it.uniroma3.persistence.UtenteDao;

@WebServlet("/loginUser")
public class LoginUser extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{	
			
		//Parametri in entrata
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		//Facade facade = new Facade();
		Utente utente = Facade.Login(username, password);
		if (utente != null) {
			HttpSession session = request.getSession();
			session.setAttribute("Utente", utente);
			request.setAttribute("Dialog", new Dialog("Login effettuato"));
		} else{
			request.setAttribute("Dialog", new Dialog("username o password errata"));			
		}
		
		String nextPage = "/index.jsp";
		ServletContext application = getServletContext();		
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);		
		rd.forward(request,response);
	}
}
