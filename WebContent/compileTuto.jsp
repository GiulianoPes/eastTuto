<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="it.uniroma3.model.Categoria"
    import="java.util.List"%>    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Compila il Tuto</title>
	<link rel="stylesheet" href="css/style_compileTuto.css"> 
</head>
<% List<Categoria> categorie = (List<Categoria>) request.getAttribute("categorie");%>
<body>
	
	<div class="wrapper">
		<div class="container">		
			<form class="conteinerTuto" action="addTuto" method="post">
				<input type="text" name="nome" placeholder="Nome">
				<input type="text" name="descrizione" placeholder="Descrizione">
 				<select name="categoria">
 					<% for(Categoria categoria : categorie) { %>
						<option><%=categoria.getNome()%></option>
					<% } %>
				</select>
				<input type="submit">		
			</form>
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
</body>
</html>