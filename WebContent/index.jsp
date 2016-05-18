<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.uniroma3.model.Utente"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-2.1.4.js"></script>

<link rel="stylesheet" href="css/style_home.css">
<title>easyTuto</title>
</head>
<body>
	<div class="wrapper">

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


		<%
			Utente utente = (Utente) session.getAttribute("Utente");
		%>

		<div id="header">
			<center>
				<table style="width: 100%;">
					<col width="20%">
					<col width="50%">
					<col width="30%">
					<tr>
						<td style="text-align:left; padding-left: 25px;"><h1>easyTuto</h1></td>
						<td>
							<div id="searchBox">
								<form class="profileBoxForm" action="search">
									<table>
										<tr>
											<td><input id="searchBar" type="text" name="searchValure"></td>
											<td><input class="profileBoxFormInput" type="button" value="cerca"></td>
										</tr>
									</table>
								</form>
							</div>
						</td>
						<td style="text-align:right;">
							<% if (utente == null) { %>
							<div id="userProfileBox">
								<table>
									<tr>
										<td style="text-align: right;">
											<form class="profileBoxForm" action="login.jsp">
												<input class="profileBoxFormInput" type="submit" value="Login">
											</form>
										</td>
					
										<td style="text-align: right;">
											<form class="profileBoxForm" action="register.jsp">
												<input class="profileBoxFormInput" type="submit"
													value="Registrati">
											</form>
										</td>
									</tr>
								</table>
							</div>
							<% } else { %>
							<div id="userProfileBox">
								<table>
									<tr>
										<td style="text-align: right;">
											<div style="postion: absolute;">
												<%="ciao " + utente.getUsername()%>
											</div>
										</td>
										<td style="text-align: right;">
											<form class="profileBoxForm" action="logoutUser" method="post">
												<input class="profileBoxFormInput" type="submit" value="logout">
											</form>
										</td>
										<td style="text-align: right;">
											<form class="profileBoxForm" >
												<input class="profileBoxFormInput" type="button" value="<%=utente.getUsername() %>" id="personalPage">
											</form>
										</td>
									</tr>
								</table>
							</div>
							<% } %>
						</td>
					</tr>
				</table>
			</center>
		</div><!-- chiusura header -->
		
		
		<div class="container"></div>
	</div>
	<script src="js/index.js"></script>
</body>
</html>