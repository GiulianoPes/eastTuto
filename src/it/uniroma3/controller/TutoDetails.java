package it.uniroma3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma3.model.Tuto;
import it.uniroma3.model.Utente;

@WebServlet("/tutoDetails")
public class TutoDetails extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utente utente = (Utente)session.getAttribute("Utente");
		
		String id = request.getParameter("tutoId");
		Long tutoId = Long.parseLong(id, 10);
		
		Tuto tuto = Facade.getTutoFromId(tutoId);
		
		session.setAttribute("Tuto", tuto);
		
		String nextPage = "/tutoDetails.jsp";
		ServletContext application = getServletContext();		
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);		
		rd.forward(request,response);
	}
}