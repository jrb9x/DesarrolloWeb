<?php
require_once ("../Models/DAOS/DelegadosDAO.php");
function login()
{

    if($_POST["password"]=="yekois"){

        session_start();
        $_SESSION["admin"] = "adminLogueado";
        var_dump($_SESSION["admin"]);

    }

    else{
        echo "Login fallido";
    }

}

function logoutAdmin(){
    session_unset();
    session_destroy();
}

if (!empty($_POST)) {
    login();
}
