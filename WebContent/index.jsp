<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.uniroma3.model.Utente"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>easyTuto</title>
	<link rel="stylesheet" href="css/style.css"> 
</head>
<body>
	<div class="wrapper">
		<div class="container">
			<h1>easyTuto</h1>
			<%
				Utente utente = (Utente) session.getAttribute("Utente");
			%>
			<%
				if (utente == null) {
			%>
			<form action="login.jsp">
    			<input type="submit" value="Login">
			</form>
			<form action="register.jsp">
   				 <input type="submit" value="Registrati">
			</form>
			<%
				} else {
			%>
			<%="ciao " + utente.getUsername()%>		
			
			<form action="logoutUser" method="post">
				<input type="submit" value="logout">
			</form>	
			<form action="compileTuto.jsp">
   				 <input type="submit" value="Compila il tuo Tuto">
			</form>				
			<%
				}
			%>
		</div>
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
    <script src="js/index.js"></script>    

</body>
</html>