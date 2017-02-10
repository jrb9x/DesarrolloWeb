<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Agenda Web</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="Styles/estiloPrincial.css">
</head>
<body>
<main>
    <header>
        <table>
            <tr>
                <td><div id="titulo"><h1>Agenda Web</h1></div></td>
            </tr>
        </table>
    </header>
    <section class="formulario" id="nuevoUsuario">
        <form:form modelAttribute="usuario" method="POST">    
        	<spring:message code="label.nombre"/><form:input path="nombre"/>
			<form:errors path="nombre"></form:errors>
			<spring:message code="label.password"/><form:input path="password"/>
        	<form:errors path="password"></form:errors>
            <br><button type="submit"><img title="login" src="iconos/guardar.png" width="50px" height="50px"></button>
        </form:form>
    </section>
</main>
</body>
</html>