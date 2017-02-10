<?php

require_once("../Beans/Eventos.php");
require_once("../Models/DAOS/EventoDAO.php");
require_once("UtilViews.php");
require_once("UtilForms.php");

function registrarEvento()
{
    $formulario = $_POST;

    if (validarFormulario("eventos", $formulario)) {

        $eventoNuevo = new Eventos();
        $eventoNuevo->setCupo($formulario["cupo"]);
        $eventoNuevo->setDescripcion($formulario["descripcion"]);
        $eventoNuevo->setDuracion($formulario["duracion"]);
        $eventoNuevo->setFechaFin($formulario["fechaFin"]);
        $eventoNuevo->setFechaInicio($formulario["fechaInicio"]);
        $eventoNuevo->setFechaModificacion(new DateTime());
        $eventoNuevo->setHora($formulario["hora"]);
        $eventoNuevo->setLugar($formulario["lugar"]);
        $eventoNuevo->setTipo($formulario["tipo"]);

        $eventoDAO = new EventoDAO();
        $eventoDAO->insert($eventoNuevo);
        UtilViews::redirigirA("../Views/vistaEventos.html");


    } else {
        echo "Formulario erróneo";
    }

}

function mostrarEventos()
{
    $eventoDAO = new EventoDAO();
    $arrayEventos = $eventoDAO->selectAll();

    $result = "";

    foreach ($arrayEventos as $fila) {
        $result = "<div>";
        $result .= "<h3>" . $fila["tipo"] . "</h3>";
        $result .= "<ul>";
        $result .= "<li>Fecha de inicio: " . $fila["fechaInicio"] . "</li>";
        $result .= "<li>Hora: " . $fila["hora"] . "</li>";
        $result .= "<li>Fecha de fin: " . $fila["fechaFin"] . "</li>";
        $result .= "<li>Duración: " . $fila["duracion"] . " horas</li>";
        $result .= "<li>Lugar: " . $fila["lugar"] . "</li>";
        $result .= "<li>Descripción: " . $fila["descripcion"] . "</li>";
        $result .= "<li>Cupo: " . $fila["cupo"] . " plazas</li>";
        $result .= "</ul>";
        $result .= "</div>";
    }

    return $result;
}

function crearSelectEventos()
{
    $eventoDAO = new EventoDAO();
    $arrayEventos = $eventoDAO->selectAll();
    $options = 0;
    foreach ($arrayEventos as $fila) {
        $options .= "<option value='" . $fila["idEvento"] . "'>" . $fila["tipo"] . " (" . $fila["fechaInicio"] . "," . $fila["hora"] . ")</option>";
    }
    return $options;
}

if (!empty($_POST)) {
    registrarEvento();
}
