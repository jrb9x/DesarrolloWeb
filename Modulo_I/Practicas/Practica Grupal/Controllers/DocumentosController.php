<?php

require_once("../Beans/Documentos.php");
require_once("../Models/DAOS/DocumentacionDAO.php");
require_once("UtilViews.php");
require_once("UtilForms.php");

function registrarDocumentos()
{
    $formulario = $_POST;

    if (validarFormulario("documentos", $formulario)) {
        $documentosNuevo = new Documentos();
        $documentosNuevo->setTitulo($formulario["titulo"]);
        $documentosNuevo->setDescripcion($formulario["descripcion"]);
        $documentosNuevo->setFechaPublicacion($formulario["fechaPubli"]);
        $documentosNuevo->setPrivado($formulario["privado"]);
        $documentosNuevo->setLey($formulario["ley"]);
        $documentosNuevo->setFechaModificacion(new DateTime());

    if (is_uploaded_file($_FILES['archivo']['tmp_name'])) {
        $dir_archivo = '../Views/Resources/Documentos/';
        $archivo_path = $dir_archivo . $_FILES['archivo']['name'];
        $extension = pathinfo($archivo_path, PATHINFO_EXTENSION);
        $archivo_subido = $dir_archivo . $formulario["titulo"] . "." . $extension;
        if (move_uploaded_file($_FILES['archivo']['tmp_name'], $archivo_subido))
            $documentosNuevo->setArchivo($archivo_subido);
        else
            echo "Posible ataque de subida de ficheros";
    }

        $documentosDAO = new DocumentosDAO();
        $documentosDAO->insert($documentosNuevo);
        UtilViews::redirigirA("../Views/vistaDocumentos.php");
    }

}

function mostrarDocumentos()
{
    $documentosDAO = new DocumentosDAO();
    $arrayDocumentos = $documentosDAO->selectAll();
    $txt = "";
    foreach ($arrayDocumentos as $fila) {
        if ($fila["ley"] == 0)
            $txt .= "<div><h1>".$fila['titulo']."</h1>"
                    ."<p>".$fila["descripcion"] ."</p>"
                    ."<span>".$fila["fechaPublicacion"]."</span><br>"
                    ."<a href=".$fila["archivo"].">".$fila["titulo"].".pdf</a></div>";
    }
    return $txt;
}
function mostrarLeyes(){
    $documentosDAO = new DocumentosDAO();
    $arrayDocumentos = $documentosDAO->selectAll();
    $txt = "";
    foreach ($arrayDocumentos as $fila) {
        if ($fila["ley"] == 1)
            $txt .= "<div><h1>".$fila['titulo']."</h1>"
                    ."<p>".$fila["descripcion"] ."</p>"
                    ."<span>".$fila["fechaPublicacion"]."</span><br>"
                    ."<a href=".$fila["archivo"].">".$fila["titulo"].".pdf</a></div>";
    }
    return $txt;
}

if(!empty($_POST)){
    registrarDocumentos();
}
