<%@ page import="beans.Persona" %>
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
                <td><div id="volver"><a href="principal.jsp"><img title="Volver" src="iconos/volver.png" width="50px" height="50px"/></a></div></td>
                <td><div id="titulo"><h1>Agenda de <%= (String) session.getAttribute("login") %></h1></div></td>
                <td><div id="logout"><a href="logout.jsp"><img title="Logout" src="iconos/logout.png" width="50px" height="50px"></a></div></td>
			</tr>
		</table>
	</header>
<section id="nuevoContacto">
    <div id="formulario">
        <fieldset>
        <form id="contacto" action="ServletGuardarContacto" method="POST" >
            <label for="nombre">Nombre</label><input value="<%= (String) session.getAttribute("nombreContacto")%>" type="text" name="nombre" id="nombreContacto" tabindex="1"></input>
            <label for="apellidos">Apellidos</label><input value="<%= (String) session.getAttribute("apellidoContacto")%>" type="text" name="apellidos" id="apellidosContacto" tabindex="2"></input>
            <label for="dni">DNI</label><input value="<%= (String) session.getAttribute("dniContacto")%>" type="text" name="dni" id="dniContacto" tabindex="3"></input>
            <label for="telefono">Telefono</label><input value="<%= (String) session.getAttribute("telefonoContacto")%>" type="text" name="telefono" id="telefonoContacto" tabindex="4"></input>
            <label for="fecha">Fecha Nacimiento</label><input value="<%= (String) session.getAttribute("fechaContacto")%>" type="text" name="fecha" id="fechaContacto" tabindex="5"></input>
            <input name="id" type="hidden" value="<%= session.getAttribute("id")%>">
            <input name="usuario" type="hidden" value="<%= session.getAttribute("login")%>">
            <br><button type="submit" onclick="submit(this)" tabindex="6"><img title="login" src="iconos/guardar.png" width="50px" height="50px"></button>
            </form><br>
        </fieldset>
        </div>
    </section>
</main>
</body>
</html>
