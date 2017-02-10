<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<%@ page import = "java.io.*, java.util.*, javax.servlet.*, javax.servlet.annotation.*, javax.servlet.http.*" %>
<%@ page import = "beans.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
		<link rel="stylesheet" href="css/estilos.css">
		<title>IMBD - Peliculas</title>
    </head>
    <body>
		<%  Usuario usuario = (Usuario) session.getAttribute("usuarioLogado"); %>
		<main>
			<header>
				<div id="cajaCabecera">
					<div id="cajaCabeceraIzq">
						<a href="ServletPrincipal"><img src="imagenes/logo.png" width="190" height="137"/></a>
					</div>
					<div id="cajaCabeceraMed">
						<form action="ServletBuscar" method="post">
							<input id="txtBuscar" name="texto" type="text" size="37" placeholder="Buscar pelicula o celebrity"/>
							<input type="image" src="imagenes/botonBuscar.png" alt="Submit" width="55px" height="55px"/>
						</form>
					</div>
					<div id="cajaCabeceraDer">
						<label><%= usuario.getNombre()%></label><br/>
						<a href="ServletModificarUsuario?idModificar= <%= usuario.getId() %>"><img src="imagenes/botonEditar.png" width="50px" height="64px"/></a>
						<a href="ServletLogout"><img src="imagenes/botonLogout.png" width="50px" height="64px"/></a>
					</div>
				</div>
			</header>
			<section>
				<div id="cajaVacia"></div>
				<div id="cajaModificarUsuario">
					<h2 style="text-align:center">Editar usuario</h2><br/>
					<form action="ServletModificarUsuario" method="post" id="formModificarUsuario">
						<table>
							<tr>
								<td>Nombre:</td>
								<td><input type="text" name="nombre" value="<%= usuario.getNombre() %>"/></td>
							</tr>
							<tr>
								<td>Password:</td>
								<td><input type="password" name="password" value="<%= usuario.getPassword() %>"/></td>
							</tr>
						</table>
						<br/><a href="ServletBajaUsuario">Darse de baja</a><br/><br/>
						<input type="image" src="imagenes/boton_guardar.png" alt="Submit" width="55px" height="55px" style="margin-left:170px">Guardar</input>
					</form>
				</div>
			</section>
		</main>
    </body>
</html>
