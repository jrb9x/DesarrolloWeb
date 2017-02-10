<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<%@ page import = "java.io.*, java.util.*, javax.servlet.*, javax.servlet.annotation.*, javax.servlet.http.*" %>

<!DOCTYPE html>
<html>
<head>
	<title>IMBD - Peliculas</title>
	<meta charset="utf-8"/>
	<link rel="stylesheet" type="text/css" href="css/estilos.css">
</head>
<body>
	<% 	String head = request.getParameter("head");
		String mensaje = request.getParameter("msg");
	%>
	<main>
		<div id="cajaLogin">
			<div id="cajaLoginIzq">
				<img src="imagenes/logo.png" width="330" height="238"/>
			</div>
			<div id="cajaLoginDer" style="font-family:Verdana;font-size:18px">
				<div id="tituloLogin" style="margin-top:80px">
					<h2><%=head%></h2><br/>
				</div>
				<%=mensaje%><br/><br/>
				<div id="botonLogin" style="margin-right:50px">
					<a href="login.html">Ir a Login</a>
				</div>
			</div>
		</div>
	</main>
</body>
</html>