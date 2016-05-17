<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Compila il Tuto</title>
	<link rel="stylesheet" href="css/style.css"> 
</head>
<body>
	<div class="wrapper">
		<div class="container">
			<h1>Compila il Tuto</h1>			
			<form action="addTuto" method="post">
				<input type="text" name="nome" placeholder="Nome">
				<input type="text" name="descrizione" placeholder="Descrizione">
				<input type="text" name="categoria" placeholder="Categoria">
				<input type="submit">		
			</form>
		</div>
	</div>
</body>
</html>