<?php
    require_once ("../Controllers/LoginAdmin.php")
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="./Resources/CSS/Formulario.css">
    <link href="https://fonts.googleapis.com/css?family=Maven+Pro" rel="stylesheet">
    <title>Formulario de log in como administrador</title>
</head>
<body>
<h1>Formulario login administrador<h1>
    <form action="../Controllers/LoginAdmin.php" method="post" name="loginAdmin">
        <label for="password">Contraseña: </label><input type="password" name="password" id="password"><br>
        <button onclick="submit(this)">Login</button>
    </form>
</body>
</html>