<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="it.uniroma3.model.Categoria"
    import="java.util.List"%>    
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Compila il Tuto</title>
	<link rel="stylesheet" href="css/style_compileTuto.css"> 
</head>
<body>	
	<div class="wrapper">
		<div class="container">		
			<f:view>
				<h:form>
				<div>Nome: <h:inputText value="#{tutoController.nome}"	
                     required="true"
                     requiredMessage="nome del tuto obbligatorio"
                     id="nome" /> <h:message for="nome" />
				</div>
				<div>Descrizione: <h:inputText value="#{tutoController.descrizione}" 
                     required="true"
                     requiredMessage="descrizione obbligatoria"
                     id="descrizione" /> <h:message for="descrizione" />
				</div>				
				<div>Categoria:	
				<h:selectOneMenu value="#{tutoController.categoriaNome}">
   					 <f:selectItems value="#{categoriaController.categorie}" var="categoria" itemValue="#{categoria}" />
				</h:selectOneMenu>
				</div>
				<div>
					<h:commandButton value="Invia tuto"  action="#{tutoController.creaTuto}"/>
				</div>		
				</h:form>
			</f:view>
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