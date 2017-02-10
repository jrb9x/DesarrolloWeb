<?php
require_once ("../Controllers/DocumentosController.php");
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Vista Documentos</title>
</head>
<body>
<?php
    echo mostrarDocumentos();
    echo mostrarLeyes();
?>
</body>
</html>