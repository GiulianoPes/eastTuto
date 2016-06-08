<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registrazione utente</title>
	<link rel="stylesheet" href="css/style.css"> 
</head>
<body>
	<div class="wrapper">
		<div id="container">
		<h1>Register</h1>
		
		<div>
			<center><h1>${Dialog.message}</h1></center>
		</div>
		<f:view>
				<h:form>
				<div>Username: <h:inputText value="#{utenteController.username}"	
                     required="true"
                     requiredMessage="username obbligatorio"
                     id="username" /> <h:message for="username" />
				</div>
				<div>Password: <h:inputSecret value="#{utenteController.password}" 
                     required="true"
                     requiredMessage="password obbligatoria"
                     id="password" /> <h:message for="password" />
				</div>
				<div>
					<h:commandButton value="Submit"  action="#{utenteController.register}"/>
				</div>		
				</h:form>
			</f:view>
		</div>
	</div>
</body>
</html>