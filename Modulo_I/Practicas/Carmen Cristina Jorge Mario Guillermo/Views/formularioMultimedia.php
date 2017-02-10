<?php

require ("../Controllers/AlbumController_select.php");

?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" >
    <title>Formulario de multimedia a Album</title>
</head>
<body>
    <h1>Formulario para añadir contenido multimedia a un Album ya existente</h1>
    <form action="../Controllers/MultimediaController.php" method="post" enctype="multipart/form-data" name="formularioMultimedia">
        <label for="titulo">Titulo del archivo multimedia</label> <input type="text" name="titulo" id="titulo">
        <label for="albumSelect">Seleccione album</label><select id="albumSelect" name="albumSelect"><?php echo crearSelectAlbum()?></select>
        <label for="url">Añadir URL</label><input type="text" name="url" id="url">
        <label for="selectFile">Seleccionar archivo</label><input type="file" name="foto" id="selectFile">
        <button onclick="submit(this)">Añadir multimedia</button>

    </form>



</body>
</html>