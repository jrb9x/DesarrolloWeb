
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>AGENDA</title>
</head>
<body>
<%
    session = request.getSession(false);
    session.invalidate();
    response.sendRedirect("index.jsp");
%>
</body>
</html>