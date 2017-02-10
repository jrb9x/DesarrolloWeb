<?php

require("usuarioDAO.PHP");

if(isset($_POST["nombre"]) && isset($_POST["password"])) {
	
	$nombre = $_POST["nombre"];
	$pass = $_POST["password"];
	$imagen;
	
	$dir_subida = "./Perfiles/"; 
	$fichero_subido = $dir_subida . $nombre . $_FILES['imagen']['name']; 
	
	if (copy($_FILES['imagen']['tmp_name'], $fichero_subido)) { 
		 $imagen = $fichero_subido;
	} else { 
		echo "¡Posible ataque de subida de ficheros!\n"; 
	} 
	
	$usuario = new Usuario($nombre, $pass,"nuevo en redsocial",$imagen);
	$usuarioDAO = new UsuarioDAO();
	$usuarioDAO -> registrarUsuario($usuario);
	
	header("location:registroOK.html");
	
}

else{
	echo "falta algun campo por rellenar";
}

?>

