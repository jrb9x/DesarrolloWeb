<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Busqueda Ofertas</title>
</head>
<body>
<form:form modelAttribute="bo" method="POST">
<spring:message code="label.precioMax"/>: <form:input path="precioMax"/>
	<form:errors path="precioMax"></form:errors>
<spring:message code="label.numeroNoches"/>: <form:select path="numeroNoches">
		<form:option value="1">1</form:option>
		<form:option value="2">2</form:option>
		<form:option value="3">3</form:option>
		<form:option value="4">4</form:option>
		<form:option value="5">5</form:option>
		<form:option value="6">6</form:option>
	</form:select>
	
<button type="submit">buscar</button>
</form:form>

</body>
</html>


