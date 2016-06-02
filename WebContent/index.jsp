<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.uniroma3.model.Utente"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/jquery.js"></script>

<link rel="stylesheet" href="css/style_home.css">
<title>easyTuto</title>

</head>
<body>
	<div class="wrapper">
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
	<div id="header">
		<center>
			<table style="width: 100%;">
				<col width="20%">
				<col width="50%">
				<col width="30%">
				<tr>
					<td style="text-align: left; padding-left: 25px;">
						<div id="easyTutoLogo">
							<h1>easyTuto</h1>
						</div>
					</td>
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
					<td style="text-align: right;">
						<c:if test="${empty utenteLogged}">
						<div id="userProfileBox">
							<table>
								<tr>
									<td style="text-align: right;">
										<form class="profileBoxForm" action="login.jsp">
											<input class="profileBoxFormInput" type="submit"
												value="Login">
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
						</c:if>
						<c:if test="${not empty utenteLogged}">						 
						<div id="userProfileBox">
							<table>
								<tr>
									<td style="text-align: right;">
										<div style="postion: absolute;">
											
										</div>
									</td>
									<td style="text-align: right;">
									<f:view>
										<h:form>
											<h:commandButton value="logout"  action="#{sessionController.logout}"/>
										</h:form>
									</f:view>
									</td>
									<td style="text-align: right;">
										<form class="profileBoxForm" action="viewMyTuto">
											<input class="profileBoxFormInput" type="button"
												value="${utenteLogged.username }" id="personalPage">
										</form>
									</td>
									<td style="text-align: right;">
									<f:view>
										<h:form >
											<h:commandButton value="+" type="submit" action="#{categoriaController.initCategorie}"/>										
										</h:form>
									</f:view>
									</td>
								</tr>
							</table>
						</div> 
						</c:if>
					</td>
				</tr>
			</table>
		</center>
	</div>
	<!-- chiusura header -->


	<div class="container"></div>
	
	
	<script src="js/index.js"></script>
</body>
</html>