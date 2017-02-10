<?php

require("usuarioDAO.PHP");

if(isset($_POST["nombre"]) && isset($_POST["password"])) {
	
	$nombre = $_POST["nombre"];
	$pass = $_POST["password"];

	$usuario = new Usuario($nombre, $pass);
	$usuarioDAO = new UsuarioDAO();
	$usuarioDAO -> registrarUsuario($usuario);
	
	header("location:registroOK.html");
	
}

else{
	echo "falta algun campo por rellenar";
}

?>

