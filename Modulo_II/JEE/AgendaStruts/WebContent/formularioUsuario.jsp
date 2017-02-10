<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
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
            <td><div id="titulo"><h1>Agenda Web</h1></div></td>
        </tr>
    </table>
    </header>
    <section class="formulario" id="nuevoUsuario">
        <fieldset>
            <s:form action="registro" method="post" name="loginUsuario">
            	<s:textfield label="Usuario" name="nombre" tabindex="1"/>
            	<s:textfield label="Password" name="passw" tabindex="2"/>
                <br><button type="submit" onclick="submit(this)" tabindex="3"><img title="login" src="iconos/guardar.png" width="50px" height="50px"></button>
            </s:form>
        </fieldset>
    </section>
</main>
</body>
</html>