<%@page import="it.uniroma3.controller.Facade"%>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="it.uniroma3.model.Utente"
	import="it.uniroma3.model.Tuto"
	import="java.util.List"%>

<link rel="stylesheet" href="css/style_personal.css">
<link rel="stylesheet" href="css/style_tuto.css">
<link rel="stylesheet" href="css/style_follower.css">

<script src="js/tuto.js"></script>
<script src="js/follower.js"></script>


</head>
<% Utente utentePagina = (Utente) request.getAttribute("Utente");
	Utente utenteCorrente = (Utente) session.getAttribute("Utente");
%>
<script src="js/personal.js"></script>


<table style="width: 100%;"">

	<col width="20%">
	<col width="60%">
	<col width="20%">
	<tr>
		<td colspan="3">
			<div id="personalUpperBox">
				<h1><%=utentePagina.getUsername() %>'s world</h1>
				<% if((utenteCorrente!=null) && (!utentePagina.getUsername().equals(utenteCorrente.getUsername()))){ %>
					<%String seguo = "Follow";%>
					<%System.out.println(utenteCorrente.isFollowing(utentePagina)); %>
					<%System.out.println(utenteCorrente.getFollowing().toString()); %>
					<%if(utenteCorrente.isFollowing(utentePagina)){ seguo = "Following";System.out.println("+++++++++Following");}%>					
					<div>
						<input class="profileBoxFormInput" type="button" value=<%=seguo %> id="follow">
					</div>	
				<%} %>
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<div id="followerBox">Following<br>
			<% for(Utente following : utentePagina.getFollowing()) { %>
				<%@ include file="templates/follower.html"%>
				<% } %>
			</div>
		</td>
		<td>
			<div id="myTutoBox">
				<% for(Tuto tuto : utentePagina.getTuto()) { %>
				<%@ include file="templates/tuto.html"%>
				<% } %>
			</div>
		</td>
		<td>
			<div id="categoryBox">categorie</div>
		</td>
	</tr>
</table>