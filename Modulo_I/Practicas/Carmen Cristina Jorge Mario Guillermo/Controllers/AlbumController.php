<!DOCTYPE html>
<html>
<body>
<?php

//Establecer las propiedades que se recogen del formulario
require_once("../Beans/Album.php");
require_once("../Models/DAOS/MultimediaDAO.php");
require_once("../Models/DAOS/AlbumDAO.php");
require_once("UtilForms.php");
require_once ("UtilViews.php");


//Función para comprobar datos
$formulario = $_POST;
if(validarFormulario("album", $formulario)){

    registrarAlbum();
}
else
    echo "error en formulario, vuelva y revise los datos";

//Función para registar un album
function registrarAlbum(){
    global $formulario;


    $album = new Album();
    $album->setTitulo($formulario["titulo"]);
    if ($formulario["tipoAlbum"] == "imagen") {
        $album->setImagen(true);
    } elseif ($formulario["tipoAlbum"] == "video") {
        $album->setImagen(false);
    }
    $album->setFechaModificacion(new DateTime());

    $album->setArrayMultimedia = arrayMultimedia();
    $albumDAO = new AlbumDAO();
    $albumDAO->insert($album);
    UtilViews::redirigirA("vistaGaleria.php");



}
function mostrarAlbum(){
    //require_once("MultimediaController.php");
    $albumDAO = new AlbumDAO();
    $arrayAlbums = $albumDAO->selectAll();
    $albums = 0;

    foreach ($arrayAlbums as $value) {
        if($value['imagenes'])
            $albums.= "<h1>".$value['titulo']."</h1><h3>(Album de imágenes)</h3>".mostrarImagenes($value['idAlbum']);


        else
            $albums.= "<h1>".$value['titulo']."</h1><h3>(Album de videos)</h3>".mostrarVideos($value['idAlbum']);
    }
    return $albums;

}
function mostrarVideos($idAlbum){

    $multimediaDAO = new MultimediaDAO();
    $arrayMultimedia = $multimediaDAO->videosAlbum($idAlbum);

    $resultado = 0;
    foreach ($arrayMultimedia as $value){
        $resultado.= toEmbebedYoutubeURL($value['fuente']);
    }
    return $resultado;

}
function mostrarImagenes($idAlbum){

    $multimediaDAO = new MultimediaDAO();
    $arrayMultimedia = $multimediaDAO->videosAlbum($idAlbum);

    $resultado = 0;
    foreach ($arrayMultimedia as $value){
        $resultado.= toEmbebedImage($value['fuente']);
    }
    return $resultado;

}
function toEmbebedYoutubeURL($url){
    $idVideo = substr($url, -11, 11);
    $iframeVideoYT = "<iframe width='560' height='315' src='https://www.youtube.com/embed/$idVideo' frameborder='0' allowfullscreen></iframe>";
    return $iframeVideoYT;
}
function toEmbebedImage($url){
    $imagenEMb = "<img src='$url' height='315' width='560''>";
    return $imagenEMb;
}

function arrayMultimedia(){

    $multimediaDAO = new MultimediaDAO();
    $arrayMultimedia = $multimediaDAO->selectAll();
    $strId=0;
    foreach ($arrayMultimedia as $value) {
        $strId.= " ".$value['idMultimedia'];
    }
    $arrayId = explode(" ",$strId);

    return implode(", ", $arrayId);
}

?>
</body>
</html>


