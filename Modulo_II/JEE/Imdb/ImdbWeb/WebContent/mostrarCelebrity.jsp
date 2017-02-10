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
		<%  Usuario usuario = (Usuario) session.getAttribute("usuarioLogado"); 
			Celebrity celebrity = (Celebrity) session.getAttribute("celebrity");
		%>
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
				<div id="cajaCelebrity">
					<h3>Nombre: <%= celebrity.getNombre()+" "+celebrity.getApellidos()%></h3>
					<div  id="cajaTableCelebrity">
						<table>
							<tr>
								<td colspan="2" style="vertical-align:top;padding-right:20px">
									<img src="<%=celebrity.getRutaFoto()%>" width="300" height="300"/>
								</td>
								<td style="vertical-align:top">
									<b>Nacionalidad: </b><%=celebrity.getNacionalidad()%><br/>
									<b>Fecha nacimiento: </b><%=celebrity.getFechaNacimiento().getDayOfMonth()+"/"+celebrity.getFechaNacimiento().getMonthValue()+"/"+celebrity.getFechaNacimiento().getYear()%><br/>
									
									<b>Roles: </b>
									<%! String roles="";%>
									<% 	if(celebrity.isActor()){
											roles += "actor, ";
										}
										if(celebrity.isDirector()){
											roles += "director,";
										}
									%>
									<%= roles %><br/>
									<b>Peliculas:</b><br/> 
									<%! String texto=""; %>
									<%	for(Pelicula pelicula: celebrity.getListaPeliculas()){
											texto += pelicula.getTitulo()+"<br/>";
										}
									%>
									<%= texto %>
								</td>
							</tr>
						</table>
					</div>	
				</div>
			</section>
		</main>
    </body>
</html>
