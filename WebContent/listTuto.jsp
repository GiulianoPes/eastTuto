<%@page import="it.uniroma3.model.Tuto" import="java.util.List"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="css/style_tuto.css">
<script src="js/tuto.js"></script>

<c:forEach items="${tutoController.tutos}" var="tuto">
        ${tuto}<br>
</c:forEach>