<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registrazione utente</title>
	<link rel="stylesheet" href="css/style.css"> 
</head>
<body>
	<div class="wrapper">
		<div class="container">
		<h1>Register</h1>
		
		<div>
			<center><h1>${Dialog.message}</h1></center>
		</div>
		<form action="newUser" method="post">
			<input type="text" name="username" placeholder="Username">
			<input type="password" name="password" placeholder="Password">
			<input type="submit" id="login-button" value="Registrati">		
		</form>
		</div>
	</div>
</body>
</html>