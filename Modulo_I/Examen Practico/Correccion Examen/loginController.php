<?php
require("UsuarioDAO.php");
if ($_POST["nombre"] && $_POST["password"]){
	$usuariodao = new UsuarioDAO();
	$usuario = $usuariodao->recuperarUsuario($_POST["nombre"]);

	if ($usuario){
		if ($usuario->getPassword() == $_POST["password"]){
			session_start();
			$_SESSION["usuario"]=$usuario;
			header("Location:principal.php");
		}
	}
	else{
		echo "Error: no existe el usuario";
	}
}
?>