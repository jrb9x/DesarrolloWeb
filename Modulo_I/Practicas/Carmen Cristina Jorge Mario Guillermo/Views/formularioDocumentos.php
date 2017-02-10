<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario Documentos</title>
</head>
<body>
<h1>Formulario de Documentos</h1>
<form action="../Controllers/DocumentosController.php" name="formularioDocumentos" method="post" enctype="multipart/form-data">

    <label for="titulo">Titulo</label> <input type="text" name="titulo" id="titulo">
    <label for="descripcion">Descripción</label> <textarea name="descripcion" id="descripcion"></textarea>
    <label for="fechaPubli">Fecha de Publicacion</label> <input type="date" name="fechaPubli" id="fechaPubli">
    <label for="archivo">Documento</label> <input type="file" name="archivo" id="archivo">

    <label for="ley">Ley</label>
    <select name="ley" id="ley">
        <option value="0">No</option>
        <option value="1">Si</option>
    </select>

    <label for="privado">Privado</label>
    <select name="privado" id="privado">
        <option value="0">No</option>
        <option value="1">Si</option>
    </select>

    <button onclick="submit(this)">Enviar Documento</button>

</form>
</body>
</html>