<?php

$mysqli = new mysqli("localhost", "root", "", "prueba");

if ($mysqli->connect_error) {
    die('Error de Conexión (' . $mysqli->connect_errno . ') '
            . $mysqli->connect_error);
}

echo 'Éxito... ' . $mysqli->host_info . "\n";

$mysqli->close();
?>