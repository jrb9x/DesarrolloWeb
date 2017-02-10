<%@ page import="beans.Contacto" %>
<%@ page import="beans.Usuario" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agenda Web</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="Styles/estiloPrincial.css">
</head>
<body>
<main>
<header>
        <table>
            <tr>
            <% Usuario usuario = (Usuario) session.getAttribute("usuario"); 
               Contacto contacto = (Contacto) session.getAttribute("contactoModificar");
            %>
                <td><div id="volver"><a href="principal.jsp"><img title="Volver" src="iconos/volver.png" width="50px" height="50px"/></a></div></td>
                <td><div id="titulo"><h1>Agenda de <%= usuario.getNombre() %></h1></div></td>
                <td><div id="logout"><a href="ServletLogout"><img title="Logout" src="iconos/logout.png" width="50px" height="50px"></a></div></td>
			</tr>
		</table>
	</header>
<section id="nuevoContacto">
    <div id="formulario">
        <fieldset>
        <form id="contacto" action="ServletGuardarContacto" method="POST" >
            <label for="nombreContacto">Nombre</label><input value="<% 
            		if(contacto.getNombre() == null)
            			out.print("");
            		else
            			out.print(contacto.getNombre());
            	%>" type="text" name="nombre" id="nombreContacto" tabindex="1"></input>
            <label for="apellidoContacto">Apellidos</label><input value="<%
            		if(contacto.getApellidos() == null)
            			out.print("");
                		else
                			out.print(contacto.getApellidos());
            	%>" type="text" name="apellidos" id="apellidosContacto" tabindex="2"></input>
            <label for="dniContacto">DNI</label><input value="<%
            		if(contacto.getDni() == null)
            			out.print("");
                		else
                			out.print(contacto.getDni());
            	%>" type="text" name="dni" id="dniContacto" tabindex="3"></input>
            <label for="telefonoContacto">Telefono</label><input value="<%
            		if(contacto.getTelefono() == null)
            			out.print("");
                		else
                			out.print(contacto.getTelefono());
            	%>" type="text" name="telefono" id="telefonoContacto" tabindex="4"></input>
            <label for="fechaContacto">Fecha Nacimiento</label><input value="<%
            		if(contacto.getFecha() == null)
            			out.print("");
                		else
                			out.print(contacto.getFecha());
            	%>" type="date" name="fecha" id="fechaContacto" tabindex="5"></input>
            <input name="id" type="hidden" value="<%= contacto.getId()%>">
            <br><button type="submit" onclick="submit(this)" tabindex="6"><img title="login" src="iconos/guardar.png" width="50px" height="50px"></button>
            </form><br>
        </fieldset>
        </div>
    </section>
</main>
</body>
</html>
