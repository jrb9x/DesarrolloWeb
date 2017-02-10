<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" >
    <title>Formulario de multimedia a Album</title>
</head>
<body>

<?php
require_once("../Beans/Multimedia.php");
require_once ("UtilViews.php");
require_once ("../Models/DAOS/MultimediaDAO.php");
require_once("UtilForms.php");

$formulario = $_POST;

function registarMultimedia(){
    global $formulario;
    $multimedia = new Multimedia();
    //Establecer Titulo y fecha
    $multimedia->setTitulo($formulario["titulo"]);
    $multimedia->setFechaModificacion(new DateTime());

    //Establecer ruta imagen
    $fileSelect = $_FILES['foto']['name'];
    $urlSelect = $formulario["url"];

    if (trim($urlSelect) !== "") {
        $multimedia->setFuente($urlSelect);

    }
    elseif (is_uploaded_file($_FILES['foto']['tmp_name'])) {
        $dir_archivo = '../Views/Resources/Multimedia/';
        $foto_path = $dir_archivo . $_FILES['foto']['name'];
        $extension = pathinfo($foto_path, PATHINFO_EXTENSION);
        $archivo_subido = $dir_archivo . $formulario["titulo"] . "." . $extension;
        if (move_uploaded_file($_FILES['foto']['tmp_name'], $archivo_subido))
            $multimedia->setFuente($archivo_subido);
        else
            echo "Posible ataque de subida de ficheros";
    }
    else
        echo "No ha seleccionado ningún archivo";

    //Se comprueba si el archivo elegido es una imagen o no


    if (isImagen($multimedia->getFuente())) {
        $multimedia->setImagen(true);
    } else {
        $multimedia->setImagen(false);

    }

    //Se añade el identificador del album al que pertenece
    $albumSeleccionado = $formulario["albumSelect"];
    $multimedia->setIdAlbum(intval($albumSeleccionado));
    //$multimedia->setIdAlbum(1);

    $multimediaDAO = new MultimediaDAO();
    $multimediaDAO->insert($multimedia);
    UtilViews::redirigirA("vistaGaleria.php");

}




/*function toEmbebedYoutubeURL($url){
    if (isURL1($url)) {
        if(isYoutube1($url)) {
            $idVideo = substr($url, -10, 10);
            $iframeVideoYT = "<iframe width='560' height='315' src='https://www.youtube.com/embed/-$idVideo' frameborder='0' allowfullscreen></iframe>";
            return $iframeVideoYT;
        }
        elseif(isImagen($url)){
            $imagenEMb = "<img src='$url' height='315' width='560''>";
            return $imagenEMb;
        }
    }
    else{
        $imagenEMb = "<img src='$url' height='315' width='560''>";
        return $imagenEMb;
    }


}*/

//funciones para ver el tipo de fuente que tiene el archivo multimedia
function isImagen($url ){
    $pos = strrpos( $url, ".");
    if ($pos === false)
        return false;
    $ext = strtolower(trim(substr( $url, $pos)));
    $imgExts = array(".gif", ".jpg", ".jpeg", ".png", ".tiff", ".tif"); // this is far from complete but that's always going to be the case...
    if ( in_array($ext, $imgExts) )
        return true;
    return false;
}

function isYoutube1($url) {
    if (strpos($url, 'https://www.youtube') === 0) {
        return true;
    }
    elseif(strpos($url, 'https://youtu.be') === 0) {
        return true;
    }
    else {
        return false;
    }
}

function isURL1($url){
    if(filter_var($url, FILTER_VALIDATE_URL) === FALSE){
        return false;
    }
    else {
        return true;
    }
}
if(!empty($_POST)){
    if(validarFormulario("multimedia", $formulario)) {
        echo "formulario valido";
        registarMultimedia();

    }
    else{
        echo "formulario no valido";
    }
}

