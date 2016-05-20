<%@page import="it.uniroma3.model.Tuto"

import="java.util.List"%>

<link rel="stylesheet" href="css/style_tuto.css">

<script src="js/tuto.js"></script>

<% List<Tuto> listTuto = (List) request.getAttribute("listTuto"); %>
<%for(Tuto tuto:listTuto){%>
	<%@ include file="templates/tuto.html" %>
<%} %>
