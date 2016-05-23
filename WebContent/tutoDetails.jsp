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
Nome: <%= tuto.getNome() %>
Categoria: <%= tuto.getCategoria() %>
Data Creazione: <%= tuto.getDataCreazione() %>
Descrizione: <%= tuto.getDescrizione()  %>
</body>
</html>