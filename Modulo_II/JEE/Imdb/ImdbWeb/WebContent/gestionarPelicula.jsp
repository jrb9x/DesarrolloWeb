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
			Pelicula peliculaGestionada = (Pelicula) session.getAttribute("peliculaGestionada");
			session.setAttribute("listaBuscada", new ArrayList<Celebrity>());
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
				<div id="cajaGestionarPelicula">
					<h2 style="text-align:center">Gestionar pelicula</h2><br/>
					<form action="ServletGuardarPelicula" method="post" id="formGestionarPelicula">
						<table>
							<tr>
								<td>Título:</td>
								<td colspan="3"><input type="text" name="titulo" value="<%= peliculaGestionada.getTitulo() %>" size="39" required/></td>
							</tr>
							<tr>
								<td>Fecha de estreno:</td>
								<td><input type="date" name="fechaEstreno" value="<%= peliculaGestionada.getFechaEstreno() %>" required/></td>
								<td>Duración:</td>
								<td><input type="number" name="duracion" value="<%= peliculaGestionada.getDuracion() %>" min="1" max="300" required/>min</td>
							</tr>
							<tr>
								<td>Género:</td>
								<td><input type="text" name="genero" value="<%= peliculaGestionada.getGenero() %>" size="13" required/></td>
								<td>País:</td>
								<td><input type="text" name="pais" value="<%= peliculaGestionada.getPais() %>" size="13" required/></td>
							</tr>
							<tr>
								<td>Sinopsis:</td>
								<td colspan="3"><textarea cols="50" rows="5" name="sinopsis" required><%= peliculaGestionada.getSinopsis() %></textarea></td>
							</tr>
							<tr>
								<td>Link imagen:</td>
								<td colspan="3"><input type="text" name="rutaFoto" value="<%= peliculaGestionada.getRutaFoto() %>" size="39" required/></td>
							</tr>
							<tr>
								<td>Director:</td>
								<%	String director = peliculaGestionada.getDirector();
									if(director.length()==0){
								%>
								<td colspan="3"><input type="text" name="director" value="<%= director %>"/>
								    <a href="gestionarCelebrity.jsp?tipo=director">Añadir</a></td>
								<%		
									}else{
								%>
								<td colspan="3"><input type="text" name="director" value="<%= director %>"/>
									<a href="gestionarCelebrity.jsp?tipo=director">Editar</a></td>
								<%		
									}
								%>
							</tr>
							<tr>
								<td>Actores:</td>
								<%	List<Celebrity> listaCelebritys = peliculaGestionada.getListaCelebritys();
									if(listaCelebritys.size()==0){
								%>
								<td colspan="3">No hay actores añadidos.
								<a href="gestionarCelebrity.jsp?tipo=actor">Añadir</a></td>
								<%	}else{
								%>
								<td colspan="3">
									<%	for(Celebrity c: listaCelebritys){
											if(c.isActor()){
									%>
											<%= c.getNombre() +" " +c.getApellidos()%>   <a href="ServletEliminarCelebrity?idEliminar=<%= c.getId()%>">Eliminar</a><br/> 
									<%		}
										} %>	
									<a href="gestionarCelebrity.jsp?tipo=actor">Añadir</a>
								</td>
								<% } %>
							</tr>
						</table><br/>
						<input type="image" src="imagenes/boton_guardar.png" alt="Submit" width="55px" height="55px" style="margin-left:350px">Guardar</input>
					</form>
				</div>
			</section>
		</main>
    </body>
</html>
