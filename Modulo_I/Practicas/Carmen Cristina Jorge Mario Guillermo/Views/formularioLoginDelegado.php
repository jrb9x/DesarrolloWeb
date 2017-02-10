<?php
require_once ("../Controllers/LoginDelegado.php")
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="./Resources/CSS/Formulario.css">
    <link href="https://fonts.googleapis.com/css?family=Maven+Pro" rel="stylesheet">
    <title>Formulario de log in como delegado</title>
</head>
<body>
<h1>Formulario login delegado<h1>
    <form action="../Controllers/LoginDelegado.php" method="post" name="loginDelegdao">
        <label for="usuario">Usuario: </label><input type="text" name="usuario" id="usuario"><br>
        <label for="password">Contraseña: </label><input type="password" name="password" id="password"><br>
        <button onclick="submit(this)">Login</button>
    </form>
</body>
</html>