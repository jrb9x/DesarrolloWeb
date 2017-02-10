<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario Delegados</title>
</head>
<body>
<h1>Formulario de Delegados</h1>
<form action="../Controllers/DelegadosController.php" name="formularioDelegados" method="post">

    <label for="usuario">Usuario</label> <input type="text" name="usuario" id="usuario">
    <label for="password">Password</label> <input type="password" name="password" id="password">
    <label for="nombre">Nombre</label> <input type="text" name="nombre" id="nombre">
    <label for="apellidos">Apellidos</label> <input type="text" name="apellidos" id="apellidos">

    <button onclick="submit(this)">Registrar</button>

</form>
</body>
</html>