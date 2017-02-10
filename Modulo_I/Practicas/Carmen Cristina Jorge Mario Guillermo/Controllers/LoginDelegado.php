<?php
require_once ("../Models/DAOS/DelegadosDAO.php");
function login($usuario, $password)
{

    $delegadoDAO = new DelegadosDAO();
    $usuarioGuardado = $delegadoDAO->selectUsuPass($usuario);

    if($usuarioGuardado["password"]==$password){

        session_start();
        $_SESSION["usuarioLogueado"] = $usuario;
    }

    else{
        echo "Login fallido";
    }

}

function logoutDelegado(){
    unset($_SESSION["usuarioLogueado"]);
}

if (!empty($_POST)) {
    login($_POST["usuario"], $_POST["password"]);
}

