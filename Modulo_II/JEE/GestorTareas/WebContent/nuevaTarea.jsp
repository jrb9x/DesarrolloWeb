<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="beans.Usuario" %>

<html>
<head>
    <title>Gestor Tareas</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="Styles/estiloPrincial.css">
</head>
<body>
<c:set var="usuario" value="${sessionScope.usuario}" scope="page"/>
<main>
<header>
        <table>
            <tr>
                <td><div id="volver"><a href="principal.do"><img title="Volver" src="iconos/volver.png" width="50px" height="50px"/></a></div></td>
                <td><div id="titulo"><h1>Gestor Tareas de ${usuario.nombre}</h1></div></td>
                <td><div id="logout"><a href="logout.do"><img title="Logout" src="iconos/logout.png" width="50px" height="50px"></a></div></td>
			</tr>
		</table>
	</header>
<section id="nuevaTarea">
    <div id="formulario">
        <fieldset>
        	<form:form modelAttribute="agregar" method="POST">    
        		<spring:message code="label.nombre"/><form:input path="nombre"/>
				<form:errors path="nombre"></form:errors>
        		
            	<br><button type="submit" onclick="submit(this)" tabindex="2"><img title="login" src="iconos/guardar.png" width="50px" height="50px"></button>
            </form:form><br>
        </fieldset>
        </div>
    </section>
</main>
</body>
</html>