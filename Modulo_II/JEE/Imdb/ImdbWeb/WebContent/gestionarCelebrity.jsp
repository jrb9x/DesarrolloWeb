<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<%@ page import = "java.io.*, java.util.*, javax.servlet.*, javax.servlet.annotation.*, javax.servlet.http.*, java.time.*" %>
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
			ArrayList<Celebrity> listaBuscada = (ArrayList<Celebrity>) session.getAttribute("listaBuscada");
			Pelicula peliculaGestionada = (Pelicula) session.getAttribute("peliculaGestionada");
			String tipo = request.getParameter("tipo");
			/*String titulo = request.getParameter("titulo");
			Integer duracion = Integer.parseInt(request.getParameter("duracion"));
			String genero = request.getParameter("genero");
			String pais = request.getParameter("pais");
			String sinopsis = request.getParameter("sinopsis");
			String director = request.getParameter("director");
			String rutaFoto = request.getParameter("rutaFoto");
			LocalDate fechaEstreno = LocalDate.parse(request.getParameter("fechaEstreno"));
			List<Celebrity> listaCelebritys = peliculaGestionada.getListaCelebritys();
			peliculaGestionada = new Pelicula(titulo, fechaEstreno, duracion, genero, pais, sinopsis, director, listaCelebritys, rutaFoto);
			session.setAttribute("peliculaGestionada", peliculaGestionada);*/
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
				<div id="cajaGestionarCelebrity">
					<h2 style="text-align:center">Gestionar celebrity</h2><br/>
					<table id="tableGestionarCelebrity">
						<tr>
							<td id="columnaBuscar">
								Buscar celebrity:
								<div id="cajaBuscar">
									<form action="ServletBuscarCelebrity" method="post" id="formBuscarCelebrity">
										<input type="hidden" name="tipo" value="<%= tipo %>">
										<input type="text" name="cadena" id="txtCadena" size="23" placeholder="Buscar..."/>
										<input type="image" src="imagenes/boton_buscar.png" alt="Submit" width="55px" height="55px"/>
									</form><br/>	
									<u>Resultados:</u><br/>
									<%	if(listaBuscada.size()==0){
									%>
									<br/>No hay resultados.<br/>
									<%	}else{
											for(Celebrity c: listaBuscada){
									%>
									<%= c.getNombre()+" "+c.getApellidos() %>  <a href="ServletGuardarCelebrity?id=<%=c.getId()%>&tipo=<%=tipo%>">Añadir</a>
									<%		}
										} 
									%>
								</div>					
							</td>
							<td id="columnaAgregar">
								Crear <%=tipo%>:
								<div id="cajaAgregar">
									<form action="ServletGuardarCelebrity" method="post" id="formAgregarCelebrity">
										<table>
											<tr>
												<td><input type="hidden" name="tipo" value="<%=tipo%>"/></td>
											</tr>
											<tr>
												<td>Nombre:</td>
												<td><input type="text" name="nombre" size="15" required/></td>
											</tr>
											<tr>
												<td>Apellidos:</td>
												<td><input type="text" name="apellidos" size="15" required/></td>
											</tr>
											<tr>
												<td>Nacionalidad:</td>
												<td><input type="text" name="nacionalidad" size="15" required/></td>
											</tr>
											<tr>
												<td>Fecha de nacimiento:</td>
												<td><input type="date" name="fechaNacimiento" required/></td>
											</tr>
											<tr>
												<td>Link imagen:</td>
												<td><input type="text" name="rutaFoto" size="15" required/></td>
											</tr>
										</table>
										<input type="image" src="imagenes/boton_guardar.png" alt="Submit" width="55px" height="55px" style="margin-left:200px">Guardar</input>
									</form><br/><br/>
								</div>				
							</td>
						</tr>
					</table>
				</div>
			</section>
		</main>
    </body>
   
</html>
