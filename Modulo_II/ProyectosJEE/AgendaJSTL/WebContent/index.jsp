<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Agenda Web</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="Styles/estiloPrincial.css">
</head>
<body>
	<main>
		<header>
			<div id="titulo"><h1>Agenda Web</h1></div>
		</header>
		<section id="login">
			<fieldset>
			<form action="ServletLogin" method="post" name="loginUsuario">
				<label for="nombre">Usuario</label><input type="text" name="nombre" id="nombre" required tabindex="1">
				<label for="passw">Contraseña</label><input type="password" name="passw" id="passw" required tabindex="2">
				<p style="color:red"><b> <c:out value="${param.error}"/></b> </p>
				<button onclick="submit(this)" tabindex="3"><img title="login" src="iconos/login.png" width="200px" height="40px"></button>
				<br><a href="formularioUsuario.html" style="color:blue">¿Usuario nuevo? Registrese!</a>
			</form>
			</fieldset>
		</section>		
	</main>
</body>
</html>