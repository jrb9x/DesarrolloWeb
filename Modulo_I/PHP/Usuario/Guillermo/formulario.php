<?php

require_once("Usuario.php");

$errores = array();
$formulario = $_POST;
$ficheros = $_FILES;

function validarFormulario()
{

    global $formulario;
    global $ficheros;

    global $errores;

    $checked = true;

    if ($formulario["nombre"] == null OR $formulario["email"] == null OR $formulario["pass"] == null OR $formulario["fechaNac"] == null) {
        $checked = false;
        array_push($errores, "Los campos no pueden estar vacíos");
    }

    if (strlen($formulario["pass"]) < 6) {
        $checked = false;
        array_push($errores, "La contraseña no puede tener menos de 6 caractéres");
    }

    if (strpos($formulario["email"], "@") == false) {
        $checked = false;
        array_push($errores, "Email no válido(xxx@xxxx)");
    }

    if ($ficheros["imagen"]["size"] > $formulario["MAX_FILE_SIZE"]) {
        $checked = false;
        array_push($errores, "La imagen supera el tamaño permitido(10MB)");
    }
    if ($ficheros["imagen"]["type"] != "image/jpeg") {
        $checked = false;
        array_push($errores, "La imagen no cumple con el formato permitido(.jpg)");
    }

    return $checked;

}

function registrarUsuario(){

    global $formulario;
    global $ficheros;
    global $usuarioNuevo;

    $nombre = $formulario['nombre'];
    $email = $formulario['email'];
    $pass = $formulario["pass"];
    $fecha = new DateTime($formulario["fechaNac"]);
    $sexo = $formulario["sexo"];
    $intereses = $formulario["intereses"];
    $nombreImagen = $formulario['email'];

    $usuarioNuevo = new Usuario($nombre, $email, $pass, $fecha, $sexo, $intereses, $nombreImagen);
}

function login($password){

    global $usuarioNuevo;
    global $errores;

    $login = true;

    if($password != $usuarioNuevo->getPassword()){
        $login = false;
    }

    return $login;
}

function mostrarDatos($usuarioNuevo)
{
    echo $usuarioNuevo->toString();
}

function moveImageTo($carpeta)
{
    global $ficheros,$formulario;

    move_uploaded_file($ficheros["imagen"]["tmp_name"], "./".$carpeta."/" . $formulario["email"]);
}

if (validarFormulario()) {
    moveImageTo("userImages");
	registrarUsuario();   

    echo "Te has registrado satisfactoriamente<br><br>";

    if(login("123456")){
        echo "Login correcto<br><br>";
    } else{
        echo "Login incorrecto<br><br>";
    }
global $usuarioNuevo;
    mostrarDatos($usuarioNuevo);
} else {
    foreach ($errores as $error) {
        echo $error . "<br>";
    }
}