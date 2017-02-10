<?php

require_once("UtilForms.php");
require_once("../Models/DAOS/NoticiasDAO.php");
require_once("../Controllers/UtilViews.php");

function registrarNoticia()
{

    $formulario = $_POST;
    $ficheros = $_FILES;

    if (validarFormulario("noticias", $formulario)) {

        $noticiaNueva = new Noticias();
        $noticiaNueva->setCuerpo($formulario["cuerpo"]);
        $noticiaNueva->setFechaCreacion(new DateTime());
        $noticiaNueva->setFechaModificacion(new DateTime());

        if (moverFicheros($ficheros, $formulario, $noticiaNueva)) {

            $noticiaNueva->setSubtitulo($formulario["subtitulo"]);
            $noticiaNueva->setTitulo($formulario["titulo"]);

            $noticiaDAO = new NoticiasDAO();
            $noticiaDAO->insert($noticiaNueva);
            UtilViews::redirigirA("../Views/vistaNoticias.php");
        } else {
            echo "Error al mover ficheros";
        }
    }

}

function mostrarNoticias(){
    $noticiaDAO = new NoticiasDAO();
    $arrayNoticias = $noticiaDAO->selectAll();

    $result="<div>";

    foreach ($arrayNoticias as $fila) {
        $result .= "<h1>".$fila["titulo"]."</h1>";
        $result .= "<h2>".$fila["subtitulo"]."</h2>";
        $result .= "<span>".$fila["fehaCreacion"]."</span>";
        $result .= "<img class='imagenNoticia' src='".$fila["imagen"]."'>";
        $result .= "<p>".$fila["cuerpo"]."</p>";
        $result .= "<p>".$fila["subtitulo"]."</p>";
        $result .= "<img class='pieImagenNoticia' src='".$fila["pieImagen"]."'>";
    }

    $result .= "</div>";

    return $result;
}

function moverFicheros($ficheros, $formulario, $noticiaNueva)
{
    $dir_archivo = '../Views/Resources/Multimedia/';

    $imagen = $dir_archivo . $_FILES['imagen']['name'];
    $pieImagen = $dir_archivo . $_FILES['pieImagen']['name'];
    $imagenMiniatura = $dir_archivo . $_FILES['imagenMiniatura']['name'];

    $extension1 = pathinfo($imagen, PATHINFO_EXTENSION);
    $extension2 = pathinfo($pieImagen, PATHINFO_EXTENSION);
    $extension3 = pathinfo($imagenMiniatura, PATHINFO_EXTENSION);

    $archivo_subido1 = $dir_archivo . $formulario["titulo"] . "." . $extension1;
    $archivo_subido2 = $dir_archivo . $formulario["titulo"] . "PIE." . $extension2;
    $archivo_subido3 = $dir_archivo . $formulario["titulo"] . "MINI." . $extension3;

    $result = move_uploaded_file($ficheros["imagen"]["tmp_name"], $archivo_subido1);
    $result = move_uploaded_file($ficheros["pieImagen"]["tmp_name"], $archivo_subido2);
    $result = move_uploaded_file($ficheros["imagenMiniatura"]["tmp_name"], $archivo_subido3);

    $noticiaNueva->setImagen($archivo_subido1);
    $noticiaNueva->setImagenMiniatura($archivo_subido2);
    $noticiaNueva->setPieImagen($archivo_subido3);

    return $result;
}

if (!empty($_POST)) {
    registrarNoticia();
}