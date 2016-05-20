package it.uniroma3.controller;

import java.io.IOException;
import java.util.List;

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
import it.uniroma3.model.Categoria;
import it.uniroma3.model.Tuto;
import it.uniroma3.model.Utente;

@WebServlet("/viewCategory")
public class ViewCategory extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
		String nextPage = "/listTuto.jsp";
		String nomeCategoria = request.getParameter("nome");
		Categoria categoria = Facade.getCategoria(nomeCategoria);
		List<Tuto> listTuto = categoria.getTuto();	
		request.setAttribute("listTuto", listTuto);
		System.out.println("-----------------"+listTuto.size());
		
		ServletContext application = getServletContext();		
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);		
		rd.forward(request,response);	
	}
}
