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
				<h1 style="position: absolute; top: 5px;">easyTuto</h1>


				<div id="searchBox">
					<form class="profileBoxForm" action="search">
						<table>
							<tr>
								<td><input id="searchBar" type="text" name="searchValure"></td>
								<td><input class="profileBoxFormInput"
									style="height: 40px;" type="submit" value="cerca"></td>
							</tr>
						</table>
					</form>
				</div>
			</center>
			<%
				if (utente == null) {
			%>
			<div id="userProfileBox">
				<table>
					<tr>
						<td>
							<form class="profileBoxForm" action="login.jsp">
								<input class="profileBoxFormInput" type="submit" value="Login">
							</form>
						</td>

						<td>
							<form class="profileBoxForm" action="register.jsp">
								<input class="profileBoxFormInput" type="submit"
									value="Registrati">
							</form>
						</td>
					</tr>
				</table>
			</div>


			<%
				} else {
			%>
			<div id="userProfileBox">
				<table>
					<tr>
						<td>
							<div style="postion: absolute;">
								<%="ciao " + utente.getUsername()%>
							</div>
						</td>
						<td>
							<form class="profileBoxForm" action="logoutUser" method="post">
								<input class="profileBoxFormInput" type="submit" value="logout">
							</form>
						</td>
						<td>
							<form class="profileBoxForm" >
								<input class="profileBoxFormInput" type="button" value="MyTuto" id="myTuto">
							</form>
						</td>
					</tr>
				</table>
			</div>
			<%
				}
			%>
		</div>
		<div class="container"></div>
	</div>
	<script src="js/index.js"></script>
</body>
</html>