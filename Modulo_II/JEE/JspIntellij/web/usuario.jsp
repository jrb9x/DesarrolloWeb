<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP</title>
</head>
<body>
<h1>
    <%
        /*
        String nombre = request.getParameter("nombre");
        String age = (String)request.getAttribute("age");
        */

        String nombre = (String)session.getAttribute("nombre");
        String anios = (String)session.getAttribute("años");

        String message = nombre + " tienes " + anios + " años";
    %>
    <%=message%>
</h1>
</body>
</html>