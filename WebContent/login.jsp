<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Login</title>    
    <link rel="stylesheet" href="css/style.css">    
  </head>  
  <body>
    <div class="wrapper">
		<div class="container">
			<h1>Welcome</h1>		
				<form action="loginUser" method="post" class="form">
					<input type="text" name="username" placeholder="Username">
					<input type="password" name="password" placeholder="Password">
					<input type="submit" id="login-button" value="Login">
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
    <script src="js/index.js"></script>    
  </body>
</html>
