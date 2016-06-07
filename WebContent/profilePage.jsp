<%@page import="it.uniroma3.controller.Facade"%>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="it.uniroma3.model.Utente"
	import="it.uniroma3.model.Tuto"
	import="java.util.List"%>
	
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="css/style_personal.css">
<link rel="stylesheet" href="css/style_tuto.css">
<link rel="stylesheet" href="css/style_follower.css">

<script src="js/tuto.js"></script>
<script src="js/follower.js"></script>

</head>
<% //Utente utentePagina = (Utente) request.getAttribute("Utente");
//	Utente utenteCorrente = (Utente) session.getAttribute("Utente");
%>
<script src="js/personal.js"></script>


<table style="width: 100%;">

	<col width="20%">
	<col width="60%">
	<col width="20%">
	<tr>
		<td colspan="3">
			<div id="personalUpperBox">
				
				<h1>${utenteController.utente.username }</h1>
				<c:if test="${(not empty utenteLogged) && (utenteLogged==utenteController.utente)}">
				<c:set var="seguo" value="Follow"></c:set>
					<c:if test="${utenteLogged.isFollowing(utenteController.utente)}">
						<c:set var="seguo" value="Following"></c:set>									
					</c:if>
				<div>
					<input class="profileBoxFormInput" type="button" value="<c:out value="$(seguo)"/>" id="follow">
				</div>	
				</c:if>
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<div id="followerBox">Following<br>
				<c:forEach items="${utenteController.utente.following}" var="following">
        			<%@ include file="templates/follower.html"%>
				</c:forEach>
			</div>
		</td>
		<td>
			<div id="myTutoBox">
				<c:forEach items="${utenteController.utente.tuto}" var="tuto">
        			<%@ include file="templates/tuto.html"%>
				</c:forEach>
			</div>
		</td>
		<td>
			<div id="categoryBox">categorie</div>
		</td>
	</tr>
</table>