<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="it.uniroma3.model.Utente"
	import="it.uniroma3.model.Tuto"
	import="java.util.List"%>

<link rel="stylesheet" href="css/style_personal.css">

<link rel="stylesheet" href="css/style_tuto.css">

</head>
<% Utente utente = (Utente) request.getAttribute("Utente"); %>
<script src="js/personal.js"></script>


<table style="width: 100%;"">

	<col width="20%">
	<col width="60%">
	<col width="20%">
	<tr>
		<td colspan="3">
			<div id="personalUpperBox">
				<h1><%=utente.getUsername() %>'s world
				</h1>
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<div id="followerBox">Follower<br>
			<% for(Utente following : utente.getFollowing()) { %>
				<%=following.getUsername()%><br>
				<% } %>
			</div>
		</td>
		<td>
			<div id="myTutoBox">
				<% for(Tuto tuto : utente.getTuto()) { %>
				<%@ include file="templates/tuto.html"%>
				<% } %>
			</div>
		</td>
		<td>
			<div id="categoryBox">categorie</div>
		</td>
	</tr>
</table>