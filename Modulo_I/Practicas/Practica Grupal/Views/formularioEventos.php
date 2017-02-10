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
<form action="../Controllers/EventosController.php" name="formularioEventos" method="post" enctype="multipart/form-data">

    <label for="tipo">Tipo</label><input type="text" name="tipo" id="tipo">
    <label for="fechaInicio">Fecha Inicio</label> <input type="date" name="fechaInicio" id="fechaInicio">
    <label for="hora">Hora</label> <input type="text" name="hora" id="hora">
    <label for="fechaFin">Fecha Fin</label> <input type="date" name="fechaFin" id="fechaFin">
    <label for="duracion">Duración</label> <input type="number" name="duracion" id="duracion">
    <label for="lugar">Lugar</label> <input type="text" name="lugar" id="lugar">
    <label for="descripcion">Descripción</label> <textarea name="descripcion" id="descripcion"></textarea>
    <label for="cupo">Cupo</label> <input type="number" name="cupo" id="cupo">
    <button onclick="submit(this)">Crear</button>

</form>
</body>
</html>