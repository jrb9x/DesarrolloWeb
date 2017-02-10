<?php

require("class.database.php");
require("contacto.php");

class ContactoDAO{

    private $mysqli;

    function __construct(){

        $db = Database::getInstance();
        $this->mysqli = $db->getConnection();
    }

    function registrarContacto($contacto){
        $query="insert into contactos values (?,?,?,?,?,?,?)";
        $stm= $this->mysqli->stmt_init();
        $stm->prepare($query);
        $stm->bind_param("sssssss",$contacto->getIdContactos(),$contacto->getNombre(),$contacto->getApellidos(),$contacto->getTelefono(),$contacto->getEmail(),$contacto->getDireccion(),$contacto->getCodUsuario());
        $stm->execute();
        $stm->close();
    }

    function recuperarContactos($usuario){
        /*
        $query='select usuarios.nombre , usuarios.estado, usuarios.imagen
        from usuarios,  seguir
        where usuarios.nombre = seguir.usuario
        and seguir.seguidor="'.$nombre.'"';
        */
        $query= "select nombre, apellidos, telefono, email, direccion from contactos where cod_usuario=".$usuario;
        $result = $this->mysqli->query($query);
        $fila = $result -> fetch_assoc();
        if (count($fila)>0){
            $contacto = new Usuario(
                $fila['nombre'],
                $fila['apellidos'],
                $fila['telefono'],
                $fila['email'],
                $fila['direccion']);
            return $contacto;
        }else{
            return false;
        }
    }


}

?>