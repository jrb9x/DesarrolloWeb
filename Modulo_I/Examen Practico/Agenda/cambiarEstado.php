<?php
require("usuarioDAO.php");
$nuevoEstado=$_POST["estado"];
session_start();
$usuario=$_SESSION["usuario"];
$usuario->setEstado($nuevoEstado);
$usuarioDAO = new UsuarioDAO();
$usuarioDAO->actualizarUsuario($usuario);
$_SESSION["usuario"]=$usuario;
header("Location:principal.php");
?>