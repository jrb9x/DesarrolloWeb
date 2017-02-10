<?php

$mysqli = new mysqli("localhost", "root", "", "usuarios");

if ($mysqli->connect_error) {
    die('Error de Conexión (' . $mysqli->connect_errno . ') '
            . $mysqli->connect_error);
}

	
$query = "INSERT INTO usuarios VALUES ('$nombre', '$email', '$password', '$fechaNac', '$sexo', '$intereses', '$rutaImagen')";

$mysqli->close();
?>