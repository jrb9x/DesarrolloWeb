<?php

function validarFormulario($nombreFormulario, $datosFormulario)
{

    $checked = true;

    if ($nombreFormulario == "eventos") {

        if(!isset($datosFormulario["tipo"]) OR !isset($datosFormulario["descripcion"])){
            $checked = false;
        }

        if(!isset($datosFormulario["hora"]) OR !isset($datosFormulario["cupo"])){
            $checked = false;
        }

        if ($datosFormulario["fechaInicio"] == "" OR $datosFormulario["fechaFin"] == "") {
            $checked = false;
        }

    }

    if($nombreFormulario == "noticias"){

        if(!isset($datosFormulario["titulo"]) OR !isset($datosFormulario["subtitulo"])){
            $checked = false;
        }

        if(!isset($datosFormulario["cuerpo"])){
            $checked = false;
        }

    }
    if ($nombreFormulario == "album"){

        if ($datosFormulario["titulo"] == ""){
            $checked = false;
        }

        if(!isset($datosFormulario["tipoAlbum"])){
            $checked = false;
        }


    }
    if ($nombreFormulario == "multimedia"){
        //El título está puesto
        if (trim($datosFormulario["titulo"]) == ""){
            $checked = false;         

        }
        //Se ha añadido al menos una URL o se ha cargado un archivo
        if (!is_uploaded_file($_FILES['foto']['tmp_name']) AND trim($datosFormulario["url"]) ==""){
            $checked = false;
        }
        //No se ha cargado un archivo y añadido un URL a la vez
        if(is_uploaded_file($_FILES['foto']['tmp_name']) AND trim($datosFormulario["url"]) !==""){
            $checked = false;
        }


        //Si se añade una URL se comprueba que ésta es una imagen o un video de youtube
        if(trim($datosFormulario["url"]) !==""){
            if(!isImagen($datosFormulario["url"]) AND !isYoutube1($datosFormulario["url"])){
                $checked = false;
            }
            //Se comprueba que la URL es válida
            if(!isURL1($datosFormulario["url"])){
                $checked = false;
            }
        }

    }
    if($nombreFormulario=="delegados"){
        if ($datosFormulario["nombre"] == null AND $datosFormulario["password"] == null AND $datosFormulario["usuario"] == null AND $datosFormulario["apellidos"] == null) {
            $checked = false;
        }
        if (strlen($datosFormulario["password"]) < 6) {
            $checked = false;
        }
    }

    if($nombreFormulario=="solicitudDelegados") {
        if ($datosFormulario["nombre"] == null AND $datosFormulario["apellidos"] == null AND $datosFormulario["razon"] == null AND $datosFormulario["telefono"] == null AND $datosFormulario["email"] == null) {
            $checked = false;
        }
        if (strpos($datosFormulario["email"], "@") == false) {
            $checked = false;
        }
        $expresion = '/^[9|6|7][0-9]{8}$/';
        if (!preg_match($expresion, $datosFormulario["telefono"])) {
            $checked = false;
        }
    }

    if($nombreFormulario=="documentos") {
        if ($datosFormulario["titulo"] == null AND $datosFormulario["descripcion"] == null AND $datosFormulario["fechaPublicacion"] == null) {
            $checked = false;
        }
        if (!is_uploaded_file($_FILES['file']['tmp_name'])){
            $checked = false;
        }
    }

    return $checked;
}
function isImage( $url ){
    $pos = strrpos( $url, ".");
    if ($pos === false)
        return false;
    $ext = strtolower(trim(substr( $url, $pos)));
    $imgExts = array(".gif", ".jpg", ".jpeg", ".png", ".tiff", ".tif"); // this is far from complete but that's always going to be the case...
    if ( in_array($ext, $imgExts) )
        return true;
    return false;
}
function isYoutube($url) {
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
function isURL($url){
    if(filter_var($url, FILTER_VALIDATE_URL) === FALSE){
        return false;
    }
    else {
        return true;
    }
}
