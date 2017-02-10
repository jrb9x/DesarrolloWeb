<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <td><div id="titulo"><h1>Agenda de <c:out value="${sessionScope.login}"/></h1></div></td>
                <td><div id="logout"><a href="ServletLogout"><img title="Logout" src="iconos/logout.png" width="50px" height="50px"></a></div></td>
			</tr>
			</table>
		</header>
<section id="nuevoContacto">
    <div id="formulario">
        <fieldset>
        <form id="contacto" action="ServletGuardarContacto" method="POST" >
            <label for="nombreContacto">Nombre</label><input value="
            	<c:if test="${sessionScope.nombreContacto == null}" > 
             	  	<c:out value=""/>
            	</c:if>
           		<c:if test="${sessionScope.nombreContacto != null}" > 
               		<c:out value="${sessionScope.nombreContacto}"/>
            	</c:if>" type="text" name="nombre" id="nombreContacto" tabindex="1"></input>
            
         	<label for="apellidoContacto">Apellidos</label><input value="
         		<c:if test="${sessionScope.apellidoContacto == null}" > 
             	  	<c:out value=""/>
            	</c:if>
           		<c:if test="${sessionScope.apellidoContacto != null}" > 
               		<c:out value="${sessionScope.apellidoContacto}"/>
            	</c:if>" type="text" name="apellidos" id="apellidosContacto" tabindex="2"></input>
            	
            <label for="dniContacto">DNI</label><input value="
            	<c:if test="${sessionScope.dniContacto == null}" > 
             	  	<c:out value=""/>
            	</c:if>
           		<c:if test="${sessionScope.dniContacto != null}" > 
               		<c:out value="${sessionScope.dniContacto}"/>
            	</c:if>" type="text" name="dni" id="dniContacto" tabindex="3"></input>
            
            <label for="telefonoContacto">Telefono</label><input value="
            	<c:if test="${sessionScope.telefonoContacto == null}" > 
             	  	<c:out value=""/>
            	</c:if>
           		<c:if test="${sessionScope.telefonoContacto != null}" > 
               		<c:out value="${sessionScope.telefonoContacto}"/>
            	</c:if>" type="text" name="telefono" id="telefonoContacto" tabindex="4"></input>
            
            <label for="fechaContacto">Fecha Nacimiento</label><input value="
            	<c:if test="${sessionScope.fechaContacto == null}" > 
             	  	<c:out value=""/>
            	</c:if>
           		<c:if test="${sessionScope.fechaContacto != null}" > 
               		<c:out value="${sessionScope.fechaContacto}"/>
            	</c:if>" type="text" name="fecha" id="fechaContacto" tabindex="5"></input>
            	
            <input name="id" type="hidden" value="<c:out value="${sessionScope.idModificar}"/>">
            <br><button type="submit" onclick="submit(this)" tabindex="6"><img title="login" src="iconos/guardar.png" width="50px" height="50px"></button>
            </form><br>
        </fieldset>
        </div>
    </section>
</main>
</body>
</html>
