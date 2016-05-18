<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" 
	import="it.uniroma3.model.Utente"
	import="it.uniroma3.model.Tuto"
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>easyTuto | myTuto</title>
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/style_tuto.css">
</head>
<body>
	<% Utente utente = (Utente)session.getAttribute("Utente"); %>
	<div class="wrapper">
		<div class="container">
			<h1 style="padding: 10px;"><%= utente.getUsername() %>'s Tuto</h1>
			<% for(Tuto tuto : utente.getTuto()) { %>
				<%@ include file="templates/tuto.html" %>
			<% } %>
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