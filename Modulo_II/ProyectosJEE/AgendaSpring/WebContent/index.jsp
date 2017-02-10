
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
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
				<label for="password">Contraseña</label><input type="password" name="password" id="password" required tabindex="2">
				<p style="color:red"><b> <%= request.getParameter("msg")!=null?request.getParameter("msg"):""%></b> </p>
				<button onclick="submit(this)" tabindex="3"><img title="login" src="iconos/login.png" width="200px" height="40px"></button>
				<br><a href="formularioUsuario.html" style="color:blue">¿Usuario nuevo? Registrese!</a>
			</form>
			</fieldset>
		</section>		
	</main>
</body>
</html>