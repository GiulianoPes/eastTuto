<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.uniroma3.model.Utente"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>easyTuto | myTuto</title>
	<link rel="stylesheet" href="css/style.css"> 
</head>
<body>
	<div class="wrapper">
		<div class="container">
			<h1 style="padding: 10px;">myTuto</h1>
			<%
				Utente utente = (Utente)session.getAttribute("Utente");
			%>
			<div><% utente.getUsername(); %></div>
			<!-- questa div myTuto deve essere processata in una iterazione -->
			<div class="myTuto" style="padding: 10px;">
				<table style="width: 100%; border: solid;">
					<col width="20%">
					<col width="70%">
					<col width="10%">
					<tr>
						<td style="text-align: left;">
							<img src="img/tuto1.jpg" width="100px" height="100px" />
						</td>
						<td>
							<ul style="list-style:none; text-align: left;">
								<li>Nome tuto: <b>Come potare il proprio giardino</b></li>
								<li>Descrizione: <b>Potiamo il giardino utilizzando gli attrzzi adatti</b></li>
								<li>Data di creazione: <b>10-11-2015</b></li>
							</ul>
						</td>
						<td style="text-align: right;">
							<ul style="list-style:none;">
								<li><img src="img/icon32/magnifying-glass.png" width="32px" height="32px" title="Dettagli" /></li>
								<li><img src="img/icon32/pencil.png" width="32px" height="32px" title="Modifica" /></li>
								<li><img src="img/icon32/trash.png" width="32px" height="32px" title="Elimina" />:</li>
							</ul>
						</td>
					</tr>
				</table>
			</div>
			<!-- fine myTuto -->
			
			<!-- <div class="myTuto" style="padding: 10px;">
				<table style="width: 100%; border: solid;">
					<col width="20%">
					<col width="70%">
					<col width="10%">
					<tr>
						<td style="text-align: left;">
							<img src="img/tuto1.jpg" width="100px" height="100px" />
						</td>
						<td>
							<ul style="list-style:none; text-align: left;">
								<li>Nome tuto: <b>Come potare il proprio giardino</b></li>
								<li>Descrizione: <b>Potiamo il giardino utilizzando gli attrzzi adatti</b></li>
								<li>Data di creazione: <b>10-11-2015</b></li>
							</ul>
						</td>
						<td style="text-align: right;">
							<ul style="list-style:none;">
								<li><img src="img/icon32/magnifying-glass.png" width="32px" height="32px" title="Dettagli" /></li>
								<li><img src="img/icon32/pencil.png" width="32px" height="32px" title="Modifica" /></li>
								<li><img src="img/icon32/trash.png" width="32px" height="32px" title="Elimina" />:</li>
							</ul>
						</td>
					</tr>
				</table>
			</div>-->
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
    <script src="js/index.js"></script>    

</body>
</html>