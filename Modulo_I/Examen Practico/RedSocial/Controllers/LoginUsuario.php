<?php
require_once ("../Models/DAOS/UsuariosDAO.php");
require_once ("../Controllers/UsuariosController.php");

function login()
{

    if ($_POST["nombre"] && $_POST["password"]) {
        $usuarioDAO = new UsuariosDAO();
        $usuario = $usuarioDAO->selectUsuPass($_POST["nombre"]);
        if ($usuario) {
            if ($usuario->getPassword() == $_POST["password"]) {
                session_start();
                $_SESSION["usuario"] = $usuario;
                header("Location:../Views/vistaUsuario.php");
            }
        }
    }
    else{
        echo "Login fallido";
    }

}

function logout(){
    session_start();
    unset($_SESSION["usuario"]);
    header("Location:login.html");
}

if (!empty($_POST)) {
    login($_POST["nombre"], $_POST["password"]);
}

