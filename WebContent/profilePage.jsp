<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="it.uniroma3.model.Utente"
	import="it.uniroma3.model.Tuto"
	import="java.util.List"%>

<link rel="stylesheet" href="css/style_personal.css">


</head>
<% Utente utentePage = (Utente) request.getAttribute("Utente");
	Utente currentUtente = (Utente) session.getAttribute("Utente");
%>
<script src="js/personal.js"></script>


<table style="width: 100%;"">

	<col width="20%">
	<col width="60%">
	<col width="20%">
	<tr>
		<td colspan="3">
			<div id="personalUpperBox">
				<h1><%=utentePage.getUsername() %>'s world</h1>
				<% if((currentUtente!=null) && (!utentePage.getUsername().equals(currentUtente.getUsername()))){ %>
				<div>
					<input class="profileBoxFormInput" type="button" value="+Follow+" id="follow">
				</div>
				<%} %>
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<div id="followerBox">Following<br>
			<% for(Utente following : utentePage.getFollowing()) { %>
				<%=following.getUsername()%><br>
				<% } %>
			</div>
		</td>
		<td>
			<div id="myTutoBox">
				<% for(Tuto tuto : utentePage.getTuto()) { %>
				<%@ include file="templates/tuto.html"%>
				<% } %>
			</div>
		</td>
		<td>
			<div id="categoryBox">categorie</div>
		</td>
	</tr>
</table>