<%@page import="it.uniroma3.model.Tuto"

import="java.util.List"%>
<link rel="stylesheet" href="css/style_tuto.css">

<% List<Tuto> lastTuto = (List) request.getAttribute("lastTuto"); %>
<%for(Tuto tuto:lastTuto){%>
	<%@ include file="templates/tuto.html" %>
<%} %>
