<?php
    require_once ("../Controllers/UtilViews.php")
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario Noticias</title>
</head>
<body>
    <nav><?php UtilViews::importNavigator()?></nav>
    <h1>Formulario de creación de Noticias</h1>
    <form action="../Controllers/NoticiasController.php" name="formularioNoticias" method="post" enctype="multipart/form-data">

        <label for="titulo">Titulo</label> <input type="text" name="titulo" id="titulo">
        <label for="subtitulo">Subtitulo</label> <input type="text" name="subtitulo" id="subtitulo">
        <label for="cuerpo">Cuerpo</label> <input type="text" name="cuerpo" id="cuerpo">
        <label for="imagen">Imagen</label> <input type="file" name="imagen" id="imagen">
        <label for="pieImagen">Pie Imagen</label> <input type="file" name="pieImagen" id="pieImagen">
        <label for="imagenMiniatura">Imagen Miniatura</label> <input type="file" name="imagenMiniatura" id="imagenMiniatura">
        <button value="Crear" onclick="submit(this)">Crear</button>

    </form>
</body>
</html>