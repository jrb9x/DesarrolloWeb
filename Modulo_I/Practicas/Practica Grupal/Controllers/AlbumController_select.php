<?php

//Establecer las propiedades que se recogen del formulario
require_once("../Beans/Album.php");
require_once("../Models/DAOS/AlbumDAO.php");

//Función llamada en el formulario de añadir Multimedia ("formularioMultimedia.php") para desplegar un select dinámico
function crearSelectAlbum()
{
    $albumDAO = new AlbumDAO();
    $arrayAlbums = $albumDAO->selectAll();
    //$albumDAO = new AlbumDAO();
    //$arrayAlbums = $albumDAO->getArrayAlbums();
    $options=0;
    foreach ($arrayAlbums as $value) {
        $options.= "<option value='".$value['idAlbum']."'>".$value['titulo']."</option>";
    }
    return $options;
}

