<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.uniroma3.model.Utente"
	import="it.uniroma3.persistence.UtenteDao"
	import="javax.persistence.EntityManager"
	import="javax.persistence.EntityManagerFactory"
	import="javax.persistence.Persistence"
	import="java.util.List" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/jquery.js"></script>

<link rel="stylesheet" href="css/style_home.css">
<title>easyTuto</title>
<%	Utente utenteCorrente = (Utente) session.getAttribute("Utente");%>	
<% 	final EntityManagerFactory emf = Persistence.createEntityManagerFactory("users-unit");%>
<% 	final EntityManager em = emf.createEntityManager();%>
<%	UtenteDao utenteDao = new UtenteDao(em); %>
<% 	Utente utenteNonSeguito = utenteDao.findByUsername("Giuliano"); %>
</head>
<body>
	<div class="wrapper">
	<%if((utenteNonSeguito!=null) && (utenteCorrente!=null)){ %>
		<%	Iterator<Utente> iterator = utenteCorrente.getFollowing().iterator(); %>	
		<%	Utente utentePagina = iterator.next();%>
		<br><br><br><br><br><br><br>		
		<div id="personalUpperBox1" align="center">
				<h3><%=utenteCorrente.getUsername() %> - Utente loggato</h3>
				<h3><%=utenteNonSeguito.getUsername() %> - Utente non seguito</h3>
				<h1><%=utentePagina.getUsername() %>'s world</h1>
				<%String seguo = "Follow";%>			
				<%if(!utentePagina.getUsername().equals(utenteCorrente.getUsername())){ %>
					<%if(utenteCorrente.isFollowing(utentePagina)){ seguo = "Following";}%>					
					<div>
						<input class="profileBoxFormInput" type="button" value=<%=seguo %> id="follow">
					</div>
					<%}else{ %>
					<div>
						<input class="profileBoxFormInput" type="button" value=<%=seguo %> id="follow">
					</div>					
					<%}%>				
		</div>
	<%}%>	
	
	
		<div class="bubble">
			<ul class="bg-bubbles">
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</div>
	</div>
	<div id="header">
		
	</div>			
	
	<script src="js/index.js"></script>
</body>
</html>