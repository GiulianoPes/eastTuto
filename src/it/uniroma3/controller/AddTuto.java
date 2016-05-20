package it.uniroma3.controller;

import java.io.IOException;
import java.util.Date;
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
import it.uniroma3.model.Categoria;
import it.uniroma3.model.Tuto;
import it.uniroma3.model.Utente;
import it.uniroma3.persistence.CategoriaDao;
import it.uniroma3.persistence.DAO;
import it.uniroma3.persistence.TutoDao;

@WebServlet("/addTuto")
public class AddTuto extends HttpServlet {
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{

		Facade facade = new Facade();
		String nextPage = "";

		//Request
		String nomeCategoria = request.getParameter("categoria");
		String nome = request.getParameter("nome");
		String descrizione =  request.getParameter("descrizione");

		
		if(nomeCategoria != null){
			System.out.println("----------------------------"+nomeCategoria);

			Categoria categoria = Facade.getCategoria(nomeCategoria);		


			//Creo utente
			HttpSession session = request.getSession();
			Utente utente = (Utente)session.getAttribute("Utente");	

			// creo il tuto
			Tuto tuto = new Tuto();
			tuto.setNome(nome);
			tuto.setDescrizione(descrizione);
			tuto.setDataCreazione(new Date(System.currentTimeMillis()));

			//Setto gli utenti al tuto
			tuto.setCategoria(categoria);
			tuto.setUtente(utente);

			//utente.addTuto(tuto);
			//utente.getTuto().add(tuto); // TODO to fix don't add tuto in user

			//Salvo il tutto nel Db
			Facade.addNewTuto(tuto);

			//Invio su showTuto.jsp il riepilogo del tuto
			request.setAttribute("Tuto",tuto);		

			request.setAttribute("Dialog", new Dialog("Hai inserito il tuo tuto"));
			
			nextPage = "/showTuto.jsp";
		}
		else{
			List<Categoria> categorie = Facade.getCategorie();
			request.setAttribute("categorie", categorie);
			nextPage = "/compileTuto.jsp";
		}
		
		ServletContext application = getServletContext();		
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);		
		rd.forward(request,response);
	}
}
