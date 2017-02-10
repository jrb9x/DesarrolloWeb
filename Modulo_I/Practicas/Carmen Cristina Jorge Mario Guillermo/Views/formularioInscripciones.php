<?php
require_once ("../Controllers/EventosController.php");
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario de creación de Eventos</title>
</head>
<body>
<h1>Formulario de creación de Eventos</h1>
<form action="../Controllers/InscripcionesController.php" name="formularioInscripciones" method="post" enctype="multipart/form-data">

    <label for="idEvento">Evento</label>
    <select name="idEvento" id="idEvento">
        <?php echo crearSelectEventos()?>
    </select>
    <label for="nombre">Nombre</label> <input type="text" name="nombre" id="nombre">
    <label for="apellidos">Apellidos</label> <input type="text" name="apellidos" id="apellidos">
    <label for="email">Email</label> <input type="email" name="email" id="email">
    <label for="telefono">Teléfono</label> <input type="text" name="telefono" id="telefono">
    <button onclick="submit(this)">Crear</button>

</form>
</body>
</html>