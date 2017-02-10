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
			List<Pelicula> listaPeliculasFavoritas = usuario.getListaPeliculasFavoritas();
			ArrayList<Pelicula> listaPeliculas = (ArrayList<Pelicula>) session.getAttribute("listaPeliculas");
			ArrayList<Celebrity> listaCelebritys = (ArrayList<Celebrity>) session.getAttribute("listaCelebritys");
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
						<a href="modificarUsuario.jsp"><img src="imagenes/botonEditar.png" width="50px" height="64px"/></a>
						<a href="ServletLogout"><img src="imagenes/botonLogout.png" width="50px" height="64px"/></a>
					</div>
				</div>
			</header>
			<section>
				<div id="cajaVacia"></div>
				<div id="cajaFavoritos">
					<div class="cabecera">
						Mis Peliculas Favoritas:&nbsp;&nbsp;&nbsp;
						<a href="ServletMostrarPeliculasFavoritas">Ver todas</a>
					</div><br/>
					<div class="cuerpo">
						<%	if(listaPeliculasFavoritas.size()==0){
						%>
						<br/><h3>No hay peliculas favoritas añadidas.</h3><br/>
						<%		
							}else{
						%>
						<table>
							<tr>
								<% 	for (int i=0; i<listaPeliculasFavoritas.size(); i++) { 
										Pelicula pelicula = listaPeliculasFavoritas.get(i);
								%>
								<td>
									<a href="ServletMostrarPeliculas?idPelicula=<%=pelicula.getId()%>"><img src="<%=pelicula.getRutaFoto()%> n.png" width="130" height="130" style="border:1px solid black"/></a>
								</td>
								<% 		if(i==3){
											i=999999;	
										}
									} %>
							</tr>
							<tr>
								<% 	for (int i=0; i<listaPeliculasFavoritas.size(); i++) {  
										Pelicula pelicula = listaPeliculasFavoritas.get(i);
								%>
								<td>
									Titulo: <%= pelicula.getTitulo() %>
								</td>
								<% 		if(i==3){
											i=999999;	
										}
									} %>
							</tr>
						</table>
						<% } %>
					</div>
				</div>
				<div id="cajaPeliculas">
					<div class="cabecera">
						Peliculas:&nbsp;&nbsp;&nbsp;
						<a href="ServletGestionarPelicula">Añadir Pelicula</a>&nbsp;
						<a href="ServletMostrarPeliculas">Ver todas</a>
					</div><br/>
					<div class="cuerpo">
						<%	if(listaPeliculas.size()==0){
						%>
						<br/><h3>No hay peliculas añadidas.</h3><br/>
						<%		
							}else{
						%>
						<table>
							<tr>
								<% for (int i=0; i<listaPeliculas.size(); i++) { 
										Pelicula pelicula = listaPeliculas.get(i);
								%>
								<td>
									<a href="ServletMostrarPeliculas?idPelicula=<%=pelicula.getId()%>"><img src="<%=pelicula.getRutaFoto()%>" width="130" height="130" style="border:1px solid blue"/></a>
								</td>
								<% 		if(i==3){
											i=999999;	
										}
									} %>
							</tr>
							<tr>
								<% for (int i=0; i<listaPeliculas.size(); i++) { 
										Pelicula pelicula = listaPeliculas.get(i);
								%>
								<td>
									<%= pelicula.getTitulo() %>
								</td>
								<% 		if(i==3){
											i=999999;	
										}
									} %>
							</tr>
						</table>
						<% } %>
					</div>
				</div>
				<div id="cajaCelebritys">
					<div class="cabecera">
						Celebritys:&nbsp;&nbsp;&nbsp;
						<a href="ServletMostrarCelebritys">Ver todas</a>
					</div><br/>
					<div class="cuerpo">
						<%	if(listaCelebritys.size()==0){
						%>
						<br/><h3>No hay celebritys añadidas.</h3><br/>
						<%		
							}else{
						%>
						<table>
							<tr>
								<% 	for (int i=0; i<listaCelebritys.size(); i++) { 
										Celebrity celebrity = listaCelebritys.get(i);
								%>
								<td>
									<a href="ServletMostrarCelebritys?idCelebrity=<%=celebrity.getId()%>"><img src="<%=celebrity.getRutaFoto()%>" width="130" height="130" style="border:1px solid green"/></a>
								</td>
								<% 		if(i==3){
											i=999999;	
										}
									} %>
							</tr>
							<tr>
								<% 	for (int i=0; i<listaCelebritys.size(); i++) { 
										Celebrity celebrity = listaCelebritys.get(i);
								%>
								<td>
									<%= celebrity.getNombre() +" "+ celebrity.getApellidos()%>
								</td>
								<% 		if(i==3){
											i=999999;	
										}
									} %>
							</tr>
						</table>
						<% } %>
					</div>
				</div>
				<div id="cajaVacia"></div>
			</section>
		</main>
    </body>
</html>
