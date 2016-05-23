<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it.uniroma3.model.Tuto"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Tuto's details</title>
</head>
<% 
	Tuto tuto = (Tuto)session.getAttribute("Tuto");
%>
<body>
<center>
	<h2>Nome: <b><%= tuto.getNome() %></b></h2>
	<h2>Categoria: <b><%= tuto.getCategoria().getNome() %></b></h2>
	<h2>Data Creazione: <b><%= tuto.getDataCreazione() %></b></h2>
	<h2>Descrizione: <b><%= tuto.getDescrizione()  %></b></h2>
</center>
</body>
</html>