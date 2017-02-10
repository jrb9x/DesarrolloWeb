<?php

require("class.database.php");
require("usuario.php");
	
class UsuarioDAO{
		
    private $mysqli;
		
    function __construct(){
			
        $db = Database::getInstance();
        $this->mysqli = $db->getConnection();
    }
		
    function registrarUsuario($usuario){
        $query="insert into usuarios values (?,?)";
        $stm= $this->mysqli->stmt_init();
        $stm->prepare($query);
        $stm->bind_param("ss",$usuario->getNombre(),$usuario->getPassword());
        $stm->execute();
        $stm->close();
    }

    function recuperarUsuario($nombre){
        $query='select * from usuarios where nombre ="'.$nombre.'"';
        $result = $this->mysqli->query($query);
        $fila = $result -> fetch_assoc();
        if (count($fila)>0){
            $usuario = new Usuario(
                $fila['nombre'],
                $fila['password']);
            return $usuario;
        }else{
            return false;
        }
    }

}

?>