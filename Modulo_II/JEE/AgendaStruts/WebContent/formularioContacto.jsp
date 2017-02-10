<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags"%>
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
                <td><div id="volver"><a href="principal"><img title="Volver" src="iconos/volver.png" width="50px" height="50px"/></a></div></td>
                <td><div id="titulo"><h1>Agenda de <c:out value="${usuario.nombre}"/></h1></div></td>
                <td><div id="logout"><a href="logout"><img title="Logout" src="iconos/logout.png" width="50px" height="50px"></a></div></td>
			</tr>
			</table>
		</header>
	<section id="nuevoContacto">
    <div id="formulario">
    <c:set var="contacto" value="${sessionScope.contactoModificar}" scope="page"/>
        <fieldset>
        <s:form id="contacto" action="guardarContacto" method="POST" >
            
            <label for="nombre">Nombre</label>
            	<c:if test="${contacto == null}" > 
             	  	<input type='text' name='nombre' id='nombre'>
            	</c:if>
           		<c:if test="${contacto != null}" > 
               		<input type='text' name='nombre' id='nombre' value='${contacto.nombre}'>
            	</c:if>
            
         	<label for=apellidos>Apellidos</label>
         		<c:if test="${contacto == null}" > 
             	  	<input type='text' name='apellidos' id='apellidos'>
            	</c:if>
           		<c:if test="${contacto != null}" > 
               		<input type='text' name='apellidos' id='apellidos' value='${contacto.apellidos}'>
            	</c:if>
            	
            <label for="dni">DNI</label>
            	<c:if test="${contacto == null}" > 
             	  	<input type='text' name='dni' id='dni'>
            	</c:if>
           		<c:if test="${contacto != null}" > 
               		<input type='text' name='dni' id='dni' value='${contacto.dni}'>
            	</c:if>
            
            <label for="telefono">Telefono</label>
            	<c:if test="${contacto == null}" > 
             	  	<input type='text' name='telefono' id='telefono'>
            	</c:if>
           		<c:if test="${contacto != null}" >  
               		<input type='text' name='telefono' id='telefono' value='${contacto.telefono}'>
            	</c:if>
            
            <label for="fecha">Fecha Nacimiento</label>
            	<c:if test="${contacto == null}" >
             	  	<input type='date' name='fecha_cumple' id='fecha'>
            	</c:if>
           		<c:if test="${contacto != null}" > 
               		<input type='date' name='fecha_cumple' id='fecha' value='${contacto.fecha}'>
            	</c:if>
            	
            <input name="id" type="hidden" value="<c:out value="${contacto.id}"/>">
            <br><button type="submit" onclick="submit(this)" tabindex="6"><img title="login" src="iconos/guardar.png" width="50px" height="50px"></button>
            </s:form><br>
        </fieldset>
        </div>
    </section>
</main>
</body>
</html>
