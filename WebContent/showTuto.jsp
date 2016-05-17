<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Il tuo Tuto</title>
	<link rel="stylesheet" href="css/style.css"> 
</head>
<body>
	<div class="wrapper">
		<div class="container">
			<h1>${Dialog.message}</h1>
			<div>
				${Tuto.getUtente().getUsername()}<br>
				${Tuto.getCategoria().getNome()}<br>		
				${Tuto.getNome()}<br>
				${Tuto.getDescrizione()}<br>
				${Tuto.getDataCreazione()}<br>
			</div>
			<form action="index.jsp">
    			<input type="submit" value="Torna alla home" >
			</form>	
		</div>
	</div>
</body>
</html>