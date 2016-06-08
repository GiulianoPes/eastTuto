<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:c="http://java.sun.com/jsp/jstl/core">  
<script src="js/homeContent.js"></script>
<head>
<link rel="stylesheet" href="css/style_home_Content.css"></link>
</head>


<div class="box" id="categoryBox">
	<table>
		<tr>
			<td>
				<div class="categoryItem" id="giardinaggio"></div>
			</td>
			<td>
				<div class="categoryItem" id="sport"></div>
			</td>
			<td>
				<div class="categoryItem" id="home_made"></div>
			</td>
			<td>
				<div class="categoryItem" id="pesca"></div>
			</td>
		</tr>
		<tr>
			<td>
				<div class="categoryItem" id="cucinare"></div>
			</td>
			<td>
				<div class="categoryItem" id="home_made"></div>
			</td>
			<td>
				<div class="categoryItem" id="giardinaggio"></div>
			</td>
			<td>
				<div class="categoryItem" id="cucinare"></div>
			</td>
		</tr>

	</table>
</div>
<div class="box" id="lastTuto">
<f:view>
	<h:form>
	${tutoController.initTuto}
	<c:forEach var="tuto" items="${tutoController.tutos}" >
		${tuto}
		pa
		<%@ include file="templates/tuto.html" %>
	</c:forEach>
	</h:form>>
</f:view>
</div>
</html>