<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>

<html>
<head>
<sx:head/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="formulario" method="post">
Nombre: <input type="text" name="nombre"/><br>
Email: <input type="text" name="email"/><br>
Passw: <input type="text" name="passw"/><br>
Passw2: <input type="text" name="passw2"/><br>
Fecha Nacimiento: <sx:datetimepicker name="fechaNacimiento"/>
<input type="submit" value="Enviar"> 
</form>
</body>
</html>