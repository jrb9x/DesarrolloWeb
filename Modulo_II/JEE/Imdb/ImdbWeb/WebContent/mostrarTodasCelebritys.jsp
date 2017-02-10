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
			ArrayList<Celebrity> listaCelebritys = (ArrayList<Celebrity>) session.getAttribute("listaCelebritys");
		%>
		<%! int contador = 0; %>
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
				<div id="cajaTodasCelebrity">
					<div class="cabecera">
						<h3>Todas las celebritys:</h3><br/>
					</div>
					<div class="cuerpo">
						<%	if(listaCelebritys.size()==0){
						%>
						<br/><h3>No hay peliculas añadidas.</h3><br/>
						<%		
							}else{
						%>
						<table>
							<tr>
							<% 	for (int i=0; i<listaCelebritys.size(); i++) { 
									Celebrity celebrity = listaCelebritys.get(i);
							%>
								<td>
									<a href="ServletMostrarCelebritys?idMostrar=<%=celebrity.getId()%>"><img src="<%=celebrity.getRutaFoto()%>" width="250" height="250" style="border:1px solid black"/></a>
									<br/><%= celebrity.getNombre() +" "+celebrity.getApellidos()%>
								</td>
								
							<% 		contador++;
									if(contador==3){
										contador = 0;
							%>
								</tr>
								<tr>
							<%
									}
								}
							%>	
							</tr>
						</table>
						<% } %>
					</div>
				</div>
			</section>
		</main>
    </body>
</html>
