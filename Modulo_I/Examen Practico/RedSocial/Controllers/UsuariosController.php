<?php

require_once("../Beans/Usuarios.php");
require_once("../Models/DAOS/UsuariosDAO.php");
require_once("UtilViews.php");

function registrarUsuarios()
{
    $formulario = $_POST;

    $usuarioNuevo = new Usuarios();
    $usuarioNuevo->setNombre($formulario["nombre"]);
    $usuarioNuevo->setPassword($formulario["passw"]);
    $usuarioNuevo->setEstado($formulario["estado"]);

    if (is_uploaded_file($_FILES['imagen']['tmp_name'])) {
        $dir_archivo = '../Views/Resources/Imagenes/';
        $archivo_path = $dir_archivo . $_FILES['imagen']['name'];
        $extension = pathinfo($archivo_path, PATHINFO_EXTENSION);
        $archivo_subido = $dir_archivo . $formulario["nombre"] . "." . $extension;
        if (copy($_FILES['imagen']['tmp_name'], $archivo_subido))//copia para no crear varios archivos con mismo nombre
            $usuarioNuevo->setImagen($archivo_subido);
        else
            echo "Posible ataque de subida de ficheros";
    }

    $usuariosDAO = new UsuariosDAO();
    $usuariosDAO->insert($usuarioNuevo);
    UtilViews::redirigirA("../Views/vistaUsuario.php");

}

function mostrarUsuario()
{
    $usuariosDAO = new UsuariosDAO();
    $arrayUsuarios = $usuariosDAO->selectAll();
    $txt = "";
    foreach ($arrayUsuarios as $fila) {

        $txt .= "<form action=\"../Controllers/UsuariosController.php\" name=\"formularioUsuarios\" method=\"post\">"
            ."<table><tr>"
			."<td rowspan='3'><img src='" . $fila["imagen"] . "'width='150px' heigth='150px'></td>"
			."<td>Nombre: </td>"
			."<td>" . $fila['nombre']. "</td></tr>"

		."<tr><td>Estado: </td>"
        ."<td>" . $fila["estado"] . "</td></tr><table>"
        ."<label for=\"estado\">Cambiar estado: </label> <textarea name=\"estado\" id=\"estado\"></textarea>"
        ."<button onclick=\"cambiarEstado()\">Cambiar Estado</button>"
        ."</form>";

    }
    return $txt;
}

function cambiarEstado()
{
    require ("../Models/DAOS/UsuariosDAO.php");

    $nuevoEstado = $_POST["estado"];
    session_start();
    $usuario = $_SESSION["usuario"];
    $usuario -> setEstado($nuevoEstado);

    $usuariosDAO = new UsuariosDAO();
    $usuariosDAO->actualizarUsuario($usuario);
    $_SESSION["usuario"] = $usuario;

    header("Location:principal.php");
}

if(!empty($_POST)){
    registrarUsuarios();
}
