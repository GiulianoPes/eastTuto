<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" 
	import="it.uniroma3.model.Utente"
	import="it.uniroma3.model.Tuto"
	import="java.util.List"
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="css/style_tuto.css">

	<% Utente utente = (Utente)session.getAttribute("Utente"); %>
	
	<%= utente.getUsername() %>
	
	<% for(Tuto tuto : utente.getTuto()) { %>
		<%@ include file="templates/tuto.html" %>
	<% } %>