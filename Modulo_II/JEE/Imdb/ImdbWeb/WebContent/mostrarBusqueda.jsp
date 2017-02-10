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
			ArrayList<Pelicula> listaPeliculaBuscada = (ArrayList<Pelicula>) session.getAttribute("listaPeliculaBuscada");
			ArrayList<Celebrity> listaCelebrityBuscada = (ArrayList<Celebrity>) session.getAttribute("listaCelebrityBuscada");
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
				<h3 style="font-size:18px;font-family:Verdana;text-align:center">Resultado de búsqueda.</h3><br/>
				<div id="cajaPeliculas">
					<div class="cabecera">
						Peliculas:&nbsp;&nbsp;&nbsp;
					</div><br/>
					<div class="cuerpo">
						<%	if(listaPeliculaBuscada.size()==0){
						%>
						<br/><h3>No hay peliculas encontrada.</h3><br/>
						<%		
							}else{
						%>
						<table>
							<tr>
								<% for (int i=0; i<listaPeliculaBuscada.size(); i++) { 
										Pelicula pelicula = listaPeliculaBuscada.get(i);
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
								<% for (int i=0; i<listaPeliculaBuscada.size(); i++) { 
										Pelicula pelicula = listaPeliculaBuscada.get(i);
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
					</div><br/>
					<div class="cuerpo">
						<%	if(listaCelebrityBuscada.size()==0){
						%>
						<br/><h3>No hay celebritys encontradas.</h3><br/>
						<%		
							}else{
						%>
						<table>
							<tr>
								<% 	for (int i=0; i<listaCelebrityBuscada.size(); i++) { 
										Celebrity celebrity = listaCelebrityBuscada.get(i);
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
								<% 	for (int i=0; i<listaCelebrityBuscada.size(); i++) { 
										Celebrity celebrity = listaCelebrityBuscada.get(i);
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
