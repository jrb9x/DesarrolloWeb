<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Solicutd Delegados</title>
</head>
<body>
<h1>Formulario de Solicutd de Delegados</h1>
<form action="../Controllers/SolicitudDelegadosController.php" name="formularioSolicitudDelegados" method="post">

    <label for="nombre">Nombre</label> <input type="text" name="nombre" id="nombre">
    <label for="apellidos">Apellidos</label> <input type="text" name="apellidos" id="apellidos">
    <label for="email">Email</label> <input type="email" name="email" id="email">
    <label for="telefono">Telefono</label> <input type="number" name="telefono" id="telefono">
    <label for="razon">Razon</label> <textarea name="razon" id="razon"></textarea>

    <button onclick="submit(this)">Enviar Solicitud</button>

</form>
</body>
</html>