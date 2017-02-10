<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean class="beans.Contacto" id="contacto"/>

<html>
<head>
    <title>Agenda Web</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="Styles/estiloPrincial.css">
</head>
<body>
<main>
<c:set var="contacto" value="${sessionScope.usuario}" scope="page"/>
    <header>
        <table>
            <tr>
                <td>
                <div id="aniadir"><a href="gestionContacto"><img title="nuevo" src="iconos/aniadir.png" width="50px" height="50px"/></a></div>
                </td>
                <td>
                <div id="titulo"><h1>Agenda de <c:out value="${usuario.nombre}"/></h1></div>
                </td>
                <td><div id="logout"><a href="logout"><img title="Logout" src="iconos/logout.png" width="50px" height="50px"></a></div>
                </td>
			</tr>
		</table>
	</header>
    <section id="contactos">
        <form action="principal">
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
                <c:if test="${sessionScope.listaContactos != null}" > 
                	<c:forEach items="${sessionScope.listaContactos}" var="contacto">
                	<tr><td> <c:out value="${contacto.nombre}"/> </td>
                	<td> <c:out value="${contacto.apellidos}"/> </td>
                	<td> <c:out value="${contacto.dni}"/> </td>
                	<td> <c:out value="${contacto.telefono}"/> </td>
                	<td> <c:out value="${contacto.fecha}"/> </td>
                	
   					<td>
   						<form action="gestionContacto" method="post">
   							<button type="submit">
   								<img title="Modificar" src="iconos/modificar.png" width="25px" height="25px">
							</button>
							<input type='hidden' name='idModificar' value='${contacto.id}'/>
   						</form>
   					</td>
   					<td>
   						<form action="eliminar" method="post">
   							<button type="submit">
   								<img title="eliminar" src="iconos/eliminar.png" width="25px" height="25px">
							</button>
                			<input type='hidden' name='idEliminar' value='${contacto.id}'/>
                		</form>
                	</td></tr>
                	</c:forEach>
				</c:if>
    	</table>
    </section>
</main>
</body>
</html>
