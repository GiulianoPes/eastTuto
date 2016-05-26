<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.uniroma3.model.Utente"
	import="it.uniroma3.persistence.UtenteDao"
	import="javax.persistence.EntityManager"
	import="javax.persistence.EntityManagerFactory"
	import="javax.persistence.Persistence"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-2.1.4.js"></script>

<link rel="stylesheet" href="css/style_home.css">
<title>easyTuto</title>

</head>
<body>
	<div class="wrapper">
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
		<center>
		<form class="profileBoxForm" action="riempiDb" method="post">
			<input class="profileBoxFormInput" type="submit" value="riempiDb">
		</form>	
		</center>
	</div>			
	
	<script src="js/index.js"></script>
</body>
</html>