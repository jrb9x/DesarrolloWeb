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
			List<Pelicula> listaFavoritos = usuario.getListaPeliculasFavoritas();
			Pelicula pelicula = (Pelicula) session.getAttribute("pelicula");
			int posicion=-1;
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
				<div id="cajaPelicula">
					<h3>Título: <%= pelicula.getTitulo() %></h3><br/>
					<div  id="cajaTablePelicula">
						<table>
							<tr>
								<td colspan="2" style="vertical-align:top;padding-right:20px">
									<img src="<%=pelicula.getRutaFoto()%>" width="300" height="300"/>
								</td>
								<td style="vertical-align:top">
									<b>Fecha estreno:</b> <%=pelicula.getFechaEstreno().getDayOfMonth()+"/"+pelicula.getFechaEstreno().getMonthValue()+"/"+pelicula.getFechaEstreno().getYear()%><br/>
									<b>Duracion:</b> <%=pelicula.getDuracion()%> min<br/>
									<b>Género:</b> <%=pelicula.getGenero()%><br/>
									<b>País:</b> <%=pelicula.getPais()%><br/>
									<b>Director:</b> <%=pelicula.getDirector()%><br/>
									<b>Actores:</b> 
									<%! String texto=""; %>
									<%	for(Celebrity celebrity: pelicula.getListaCelebritys()){
											texto += celebrity.getNombre()+" "+celebrity.getApellidos()+",";
										}
									%>
									<%= texto %>
									<br/>
									<b>Sinopsis: </b><%=pelicula.getSinopsis()%><br/>
									<% 	for(int i=0;i<listaFavoritos.size();i++){
											if(listaFavoritos.get(i).getTitulo().equals(pelicula.getTitulo())){
												posicion = i;
											}
										}
										if(posicion<0){
									%>
									<a href="ServletAgregarFavoritos"><img src="imagenes/boton_addfavoritos.png" width="50px" height="50px"/></a>Add Favoritos
									<% 		
										}else{
									%>
									<u style="color:green">Guardado en Favoritos.</u>
									<%  } %>
									
								</td>
							</tr>
							<tr>
								<td>
									<a href="ServletGestionarPelicula?idModificar=<%=pelicula.getId()%>"><img src="imagenes/boton_editar.png" width="50px" height="50px"/></a>
									Editar
								</td>
								<td>
									<a href="ServletEliminarPelicula?idEliminar=<%=pelicula.getId()%>"><img src="imagenes/boton_eliminar.png" width="50px" height="50px"/></a>
									Eliminar
								</td>
								<td>
									
								</td>
							</tr>
						</table>
					</div>	
				</div>
			</section>
		</main>
    </body>
</html>
