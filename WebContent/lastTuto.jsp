<%@page import="it.uniroma3.model.Tuto"

import="java.util.List"%>

<% List<Tuto> lastTuto = (List) request.getAttribute("lastTuto"); %>
<%=lastTuto.size() %>
<table>
	<tr>
	</tr>
	<tr>
	</tr>
</table>