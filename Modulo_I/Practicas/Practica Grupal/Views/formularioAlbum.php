<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Formulario creacion Albums</title>
</head>
<body>
    <h1>Formulario para añadir contenido multimedia a un Album ya existente</h1>
    <form action="../Controllers/AlbumController.php" method="post" name="formularioAlbum">
        <label for="titulo">Titulo del nuevo Album: </label><input type="text" name="titulo" id="titulo"><br>
        <label>Tipo de Album</label><br>
        <label for="albumImagen">Imagen</label><input type="radio" name="tipoAlbum" value="imagen" id="albumImagen">
        <label for="albumVideo">Video</label><input type="radio" name="tipoAlbum" value="video" id="albumVideo">
        <button onclick="submit(this)">Crear Album</button>

    </form>
    

</body>
</html>