package it.uniroma3.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoutUser")
public class LogoutUser extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
		HttpSession session = request.getSession();
		session.invalidate();		

		ServletContext application = getServletContext();		
		String nextPage="/index.jsp";
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);		
		rd.forward(request,response);
	}
}
