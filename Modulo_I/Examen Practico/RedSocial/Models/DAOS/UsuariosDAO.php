<?php

require_once ("UtilDB.php");

class UsuariosDAO
{
    public function insert($usuarios)
    {
        $dbConnection = UtilDB::connectTo("REDSOCIAL","root","");
        $query = $dbConnection->prepare("INSERT INTO usuarios(nombre, password, imagen, estado)
                                      VALUES(                                           
                                            :nombre,
                                            :password,
                                            :imagen,
                                            :estado)");
        $query->bindParam(":nombre", $usuarios->getNombre());
        $query->bindParam(":password", $usuarios->getPassword());
        $query->bindParam(":imagen", $usuarios->getImagen());
        $query->bindParam(":estado", $usuarios->getEstado());

        //TODO other bindParams()
        $query->execute();
    }

    public function insertEstado($usuarios)
    {
        $dbConnection = UtilDB::connectTo("REDSOCIAL","root","");
        $query = $dbConnection->prepare("UPDATE usuarios SET estado
                                        VALUES(:estado)");
        $query->bindParam(":estado", $usuarios->getEstado());
        $query->execute();
    }

    public function selectAll($nombre)
    {
        $dbConnection = UtilDB::connectTo("REDSOCIAL", "root", "");
        $query = $dbConnection->prepare('SELECT * FROM usuarios WHERE nombre="'.$nombre.'"');

        $query->execute();
        return $query->fetchAll(PDO::FETCH_ASSOC);
    }

    public function selectUsuPass($usu)
    {
        $dbConnection = UtilDB::connectTo("REDSOCIAL", "root", "");
        $query = $dbConnection->prepare("SELECT nombre, password FROM usuarios WHERE nombre = '$usu'");

        $query->execute();
        return $query->fetchAll(PDO::FETCH_ASSOC) ;
    }
    function actualizarUsuario($usuario){
        $dbConnection = UtilDB::connectTo("REDSOCIAL", "root", "");
        $query = $dbConnection->prepare('UPDATE usuarios SET estado ="'.$usuario->getEstado().'"
        WHERE nombre ="'. $usuario->getNombre().'"');
        $query->execute();
    }
}