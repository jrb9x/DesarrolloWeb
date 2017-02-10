<%@ page import="beans.Tarea" %>
<%@ page import="beans.Usuario" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestor Tareas</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="Styles/estiloPrincial.css">
</head>
<body>
<main>
    <header>
        <table>
            <tr>
            <% Usuario usuario = (Usuario) session.getAttribute("usuario"); %>
                <td><div id="aniadir"><a href="agregar.do"><img title="nuevo" src="iconos/aniadir.png" width="50px" height="50px"/></a></div></td>
                <td><div id="titulo"><h1>Gestor Tareas de <%= usuario.getNombre() %></h1></div></td>
                <td><div id="logout"><a href="logout.do"><img title="Logout" src="iconos/logout.png" width="50px" height="50px"></a></div></td>
			</tr>
		</table>
	</header>
    <section id="tareas">
        <form action="principal.do" method="GET">
        	<spring:message code="label.realizada"/>:
        	<select name="realizada">
				<option name="realizada" value="0">Todas</option>
				<option name="realizada" value="1">Realizadas</option>
				<option name="realizada" value="2">No Realizadas</option>
			</select>
            <button type="submit" onclick="submit(this)"><img title="filtrar" src="iconos/filtrar.png" width="30px" height="25px"></button>
        </form>
        <br>
        <table id="tablaTareas">
            <tr>
                <th>Tarea</th>
                <th>Realizada Por</th>
                <th>Fecha</th>
                <th></th>
                <th></th></tr>
           <%
           ArrayList<Tarea> listaTareas = (ArrayList<Tarea>)session.getAttribute("listaTareas");
           if(listaTareas != null){
          		for (Tarea tarea : listaTareas) { %>
          		
          	<tr><td> <%= tarea.getNombre()%> </td>
          		
          		<%	String nombreUsuario="";
						if(tarea.getUsuario() != null){ 
							nombreUsuario = tarea.getUsuario().getNombre();	
						}
					%>
				<td><%= nombreUsuario %></td>
				
          		<%	String fechaMarcado="";
						if(tarea.getFecha()!=null){ 
							fechaMarcado = tarea.getFecha().getDayOfMonth()+"/"+
								tarea.getFecha().getMonthValue()+"/"+
								tarea.getFecha().getYear();
						}
					%>
				<td><%= fechaMarcado %></td>
          		
   				<form action="realizar.do" method="POST"><td>
					<input type="hidden" name="id" value="<%= tarea.getId()%>"/>
					<% if(!tarea.isRealizada()){ %>
						<input type="image" src="iconos/modificar.png" alt="Submit" width="25px" height="25px"/>
					<% } %>
				</td></form>
								   					
   				<form action="eliminar.do" method="POST"><td>
   					<input type="hidden" name="id" value="<%= tarea.getId()%>"/>
   					<input type="image" src="iconos/eliminar.png" alt="Submit" width="25px" height="25px"/>
   				</td></tr></form>
   			<%}} %>
    </table>
    </section>
</main>
</body>
</html>
