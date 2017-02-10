
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <title>Gestor Tareas</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="Styles/estiloPrincial.css">
</head>
<body>
	<main>
		<header>
			<div id="titulo"><h1>Gestor de Tareas</h1></div>
		</header>
		<section id="login">
			<form:form modelAttribute="usuario" method="POST">    
        		<spring:message code="label.nombre"/><form:input path="nombre"/>
				<form:errors path="nombre"></form:errors>
				<spring:message code="label.password"/><form:input path="password"/>
        		<form:errors path="password"></form:errors>
            	<br><button type="submit"><img title="login" src="iconos/login.png" width="200px" height="40px"></button>
       		 </form:form>
			<br><a href="registro.do" style="color:blue">¿Usuario nuevo? Registrese!</a>
		</section>		
	</main>
</body>
</html>