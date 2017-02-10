<?php

class usuarioDAO{
	
$mysqli = new mysqli("localhost", "root", "", "usuarios");

if ($mysqli->connect_error) {
    die('Error de Conexión (' . $mysqli->connect_errno . ') '
            . $mysqli->connect_error);
}

function insertarDatos(){
	
global $mysqli;

$query =  "INSERT INTO usuarios VALUES ('$this->nombre', '$this->email', '$this->password', '$this->fechaNac', '$this->sexo', '$cadIntereses', '$this->rutaImagen')";
$mysqli->query($query);

}


function recuperarDatos(){

global $mysqli;

$query =  "SELECT rutaImagen FROM usuarios";
$result = $mysqli->query($query);
while ($ruta = $result->fetch_array()){
	
	$nombre = explode("/", $ruta[0]);
	$nombre = explode(".", $nombre[2]);
}

return $result;
}

}

?>