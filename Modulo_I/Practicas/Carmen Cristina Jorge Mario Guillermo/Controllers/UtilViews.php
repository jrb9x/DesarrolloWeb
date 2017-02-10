<?php

class UtilViews
{
    public static function redirigirA($vista){
        header('Location: http://localhost/ProyectoEquipoA/Views/'.$vista);
    }

    public static function importNavigator(){

        //if(!empty($_SESSION["usuarioLogueado"])){
            echo file_get_contents('../Views/MenuAdministracion.html');
        //}

    }
}