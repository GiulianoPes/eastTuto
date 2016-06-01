<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%> 
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <meta charset="UTF-8">
    <title>Login</title>    
    <link rel="stylesheet" href="css/style.css">    
  </head>  
  <body>
    <div class="wrapper">
		<div class="container">
			<h1>Welcome</h1>
			<f:view>
				<h:form>
				<div>Username: <h:inputText value="#{sessionController.username}"	
					 
                     required="true"
                     requiredMessage="username obbligatorio"
                     id="username" /> <h:message for="username" />
				</div>
				<div>Password: <h:inputText value="#{sessionController.password}" 
                     required="true"
                     requiredMessage="password obbligatoria"
                     id="password" /> <h:message for="password" />
				</div>
				<div>
					<h:commandButton value="Submit"  action="#{sessionController.login}"/>
				</div>		
				</h:form>
			</f:view>
					
			<!--  
				<form action="loginUser" method="post" class="form">
					<input type="text" name="username" placeholder="Username">
					<input type="password" name="password" placeholder="Password">
					<input type="submit" id="login-button" value="Login">
				</form>		
			-->
		</div>
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
    <script src="js/index.js"></script>    
  </body>
</html>
