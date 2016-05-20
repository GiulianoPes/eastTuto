package it.uniroma3.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.dialog.Dialog;
import it.uniroma3.model.Utente;
import it.uniroma3.persistence.UtenteDao;

@WebServlet("/addFollowing")
public class AddFollowing extends HttpServlet {

	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{

		String name_following = request.getParameter("name_following");

		Utente currentUser = (Utente) request.getSession().getAttribute("Utente");
		System.out.println("-------------------------------Cerco Nel DB: "+name_following);
		Utente following = Facade.findUtenteByUsername(name_following);
		Dialog dialog = new Dialog();
		System.out.println("-------------------------------Bella, sto per aggiungere: "+following.getUsername()+" a "+currentUser.getUsername());
		if(following != null){
			Facade.addFollowing(currentUser, following);
			dialog.setMessage("success");
		}else{
			dialog.setMessage("fail");
		}

		request.setAttribute("Dialog", dialog);
		String nextPage = "/result.jsp";
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);		
		rd.forward(request,response);

	}


}
