<?php
require_once("../Beans/Inscripciones.php");
require_once("../Models/DAOS/InscripcionDAO.php");
require_once("UtilViews.php");
require_once("UtilForms.php");

function registrarInscripcion()
{
    $formulario = $_POST;

    if(validarFormulario("inscripciones",$formulario)){

        $incripcionNueva = new Inscripciones();
        $incripcionNueva->setIdEvento($formulario["idEvento"]);
        $incripcionNueva->setNombre($formulario["nombre"]);
        $incripcionNueva->setApellidos($formulario["apellidos"]);
        $incripcionNueva->setEmail($formulario["email"]);
        $incripcionNueva->setTelefono($formulario["telefono"]);

        $inscripcionDAO = new InscripcionDAO();
        $inscripcionDAO->insert($incripcionNueva);

        //TODO preparar vistas mostrar -> UtilViews::redirigirA("formularioNoticias.php");


    }

    else{
        echo "Formulario erróneo";
    }

}

if(!empty($_POST)){
    registrarInscripcion();
}