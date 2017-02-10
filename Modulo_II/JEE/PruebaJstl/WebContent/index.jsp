<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean class="beans.Mensaje" id="mensaje"/>
<jsp:useBean class="beans.Lista" id="lista"/>

<html> 
	<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
	
		<jsp:setProperty name="mensaje" property="texto" value="Esto es un mensaje"/>
	  	El valor en la variable <b>texto</b> es: <br/> <b>&quot<c:out value="${mensaje.texto}" default="El valor es null"/>&quot</b>
	 
		<%-- Creamos la variable texto con un valor String -->
		<c:set var="texto" value="valor_de_la_variable"/>
		<%-- Mostramos el valor de la variable texto -->
		El valor de la variable <b>texto</b> es : <c:out value="${texto}"/>
	 
		<p>
		<%-- Creamos la variable texto con un valor String --%>
		<c:set var="texto" value="valor_de_la_variable"/>
		<%-- Mostramos el valor de la variable texto --%>
		El valor de la variable <b>texto</b> es : <c:out
		value="${texto}"/>
		</p>
		
		<p>
		<%-- removemos la variable texto --%>
		<c:remove var="texto" scope="page"/>
		<%-- Mostramos nuevamente el valor --%>
		El valor de la variable <b>texto</b> ahora es :
		<c:out value="${texto}" default="Es Nulo"/>
		</p>
	
		<p>
		<c:catch var="excepcion">
		<%=3/0%>
		</c:catch>
		<c:if test="${excepcion != null }">
		Ocurrió una excepción : <c:out value="${excepcion}"/>
		</c:if>
		</p>
		
		<p>
		<c:set var="a" value="20"/>
		<c:if test="${a > 100}">
			La variable <b></b> es <b>mayor</b> que 100.
		</c:if>
		<c:if test="${a < 100 }">
			La variable <b></b> es <b>menor</b> que 100.
		</c:if>
		</p>
		
		<p>
		<c:set var="a" value="50"/>
		<c:choose>
			<c:when test="${a == 1}">
				<b>a</b> es 1.
			</c:when>
			<c:when test="${a == 2 }">
				<b>a</b> es 2.
			</c:when>
			<c:otherwise>
				<b>a</b> tiene un valor diferente de 1 y de 2.
			</c:otherwise>
		</c:choose>
		</p>
		
		<p>Los elementos en la lista son: </p>
		<p>
			<c:forEach var="nombreActual" items="${lista.listaDeNombres}">
				<b><c:out value="${nombreActual}"/></b> <br/>
			</c:forEach>
		</p>
		
		<c:set var="oracion" value="Estos,son,los,tokens,de,la,frase"/>
		Los tokens son los siguientes:
		<p>
			<c:forTokens items="${oracion}" delims="," var="token" varStatus="i" >
				<b><c:out value="${i.count}"/>.</b> <c:out value="${token}"/> <br/>
			</c:forTokens>
		</p>
		
		
		<p>
		<c:import url="import.jsp"/>
		Contenido de <b>index.jsp</b>
		</p>
		 
		 
		<p>
		Click en el enlace para enviar el parametro :
		<a href=" <c:url value="import.jsp"><c:param name="nombre" value="Juan"/></c:url> ">link</a>
		</p>
		
		<%--
		<c:redirect url="import.jsp">
			<c:param name="nombre" value="Juan"/>
		</c:redirect> 
		--%>
		
	</body>
</html>