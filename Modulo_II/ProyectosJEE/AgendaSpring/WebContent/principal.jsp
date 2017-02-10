<%@ page import="com.beans.Contacto" %>
<%@ page import="com.beans.Usuario" %>
<%@ page import="java.util.ArrayList" %>

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
            <% Usuario usuario = (Usuario) session.getAttribute("usuario"); %>
                <td><div id="aniadir"><a href="ServletGestionContacto"><img title="nuevo" src="iconos/aniadir.png" width="50px" height="50px"/></a></div></td>
                <td><div id="titulo"><h1>Agenda de <%= usuario.getNombre() %></h1></div></td>
                <td><div id="logout"><a href="ServletLogout"><img title="Logout" src="iconos/logout.png" width="50px" height="50px"></a></div></td>
			</tr>
		</table>
	</header>
    <section id="contactos">
        <form action="ServletPrincipal">
            <select name="mes">
                <option name="mes" value="00">Todos</option>
                <option name="mes" value="01">Enero</option>
                <option name="mes" value="02">Febrero</option>
                <option name="mes" value="03">Marzo</option>
                <option name="mes" value="04">Abril</option>
                <option name="mes" value="05">Mayo</option>
                <option name="mes" value="06">Junio</option>
                <option name="mes" value="07">Julio</option>
                <option name="mes" value="08">Agosto</option>
                <option name="mes" value="09">Septiembre</option>
                <option name="mes" value="10">Octubre</option>
                <option name="mes" value="11">Noviembre</option>
                <option name="mes" value="12">Diciembre</option>
            </select>
            <button type="submit" onclick="submit(this)"><img title="filtrar" src="iconos/filtrar.png" width="30px" height="25px"></button>
            </form>
        <br>
        <table id="tablaContactos">
            <tr>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>DNI</th>
                <th>Telefono</th>
                <th>Fecha Nacimiento</th>
                <th></th>
                <th></th></tr>
           <%
           ArrayList<Contacto> listaContactos = (ArrayList<Contacto>)session.getAttribute("listaContactos");
           if(listaContactos != null){
          		for (Contacto contacto : listaContactos) {
   				out.print("<tr><td>" + contacto.getNombre() + "</td>"+
   					"<td>" + contacto.getApellidos() + "</td>"+
   					"<td>" + contacto.getDni() + "</td>"+
   					"<td>" + contacto.getTelefono() + "</td>"+
   					"<td>" + contacto.getFecha() + "</td>"+
   					"<td><a href=\"ServletGestionContacto?idModificar=" + contacto.getId() + "\"><img title=\"Modificar\" src=\"iconos/modificar.png\" width=\"25px\" height=\"25px\"></a></td>"+
   					"<td><a href=\"ServletEliminar?idEliminar=" + contacto.getId() + "\"><img title=\"eliminar\" src=\"iconos/eliminar.png\" width=\"25px\" height=\"25px\"></a></td></tr>");
   				}
           }
    %>
    </table>
    </section>
</main>
</body>
</html>
