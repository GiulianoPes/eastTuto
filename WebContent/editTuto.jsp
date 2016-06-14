<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="it.uniroma3.model.Categoria"
    import="java.util.List"%>    
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Modifica il Tuto</title>
	<link rel="stylesheet" href="css/style_compileTuto.css"> 
</head>
<body>

	<ui:param name="tutoId" value="#{param['tutoId']}"></ui:param>
	<ui:param name="currentTuto" value="${tutoController.getTutoFromId(tutoId)}"></ui:param>
	<ui:param name="utenteProfile" value="${currentTuto.getUtente()}"></ui:param>

	<div class="wrapper">
		<div class="container">
			<h1>Modifica il Tuto</h1>		
			<f:view>
				<h:form>
				<div>Nome: <h:inputText value="${currentTuto.nome}"	
					styleClass="input-comile-tuto-text"
                    required="true"
                    requiredMessage="nome del tuto obbligatorio"
                    id="nome" /> <h:message for="nome" />
				</div>
				<div>Descrizione: <br><h:inputTextarea value="${currentTuto.descrizione}" 
					styleClass="input-compile-tuto-textarea"
                    required="true"
                    requiredMessage="descrizione obbligatoria"
                    id="descrizione" /> <h:message for="descrizione" />
				</div>				
				<div>Categoria:	
				<h:selectOneMenu style="width: 40%;" value="${currentTuto.categoriaNome}">
   					 <f:selectItems value="#{categoriaController.categorie}" var="categoria" itemValue="#{categoria}" />
				</h:selectOneMenu>
				</div>
				<br><br>
				<div>
					<h:commandButton value="Invia tuto"  action="#{tutoController.modificaTuto}"/>
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