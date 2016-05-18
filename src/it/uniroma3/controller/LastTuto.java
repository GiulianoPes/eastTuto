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
import it.uniroma3.model.Tuto;
import it.uniroma3.persistence.TutoDao;

@WebServlet("/lastTuto")
public class LastTuto extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("users-unit");
		TutoDao tutoDao = new TutoDao(emf);
		
		List<Tuto> lastTuto = tutoDao.lastTuto();
		
		request.setAttribute("lastTuto", lastTuto);
		
		System.out.println(lastTuto.size());
				
		String nextPage = "/lastTuto.jsp";
		ServletContext application = getServletContext();		
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);		
		rd.forward(request, response);
	}

}

