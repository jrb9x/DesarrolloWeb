<?php

require_once ("UtilDB.php");

class DelegadosDAO
{
    public function insert($delegados)
    {
        $dbConnection = UtilDB::connectTo("ccoo","root","");
        $query = $dbConnection->prepare("INSERT INTO delegados(usuario, password, nombre, apellidos)
                                      VALUES(                                           
                                            :usuario,
                                            :password,
                                            :nombre,
                                            :apellidos)");
        $query->bindParam(":usuario", $delegados->getUsuario());
        $query->bindParam(":password", $delegados->getPassword());
        $query->bindParam(":nombre", $delegados->getNombre());
        $query->bindParam(":apellidos", $delegados->getApellidos());
        //TODO other bindParams()
        $query->execute();
    }
    public function selectAll()
    {
        $dbConnection = UtilDB::connectTo("ccoo", "root", "");
        $query = $dbConnection->prepare('SELECT * FROM delegados');

        $query->execute();
        return $query->fetchAll(PDO::FETCH_ASSOC);
    }
    public function selectUsuPass($usu)
    {
        $dbConnection = UtilDB::connectTo("ccoo", "root", "");
        $query = $dbConnection->prepare('SELECT usuario, password FROM delegados WHERE usuario = $usu');

        $query->execute();
        return $query->fetchAll(PDO::FETCH_ASSOC) ;
    }
}

/**
 * Created by PhpStorm.
 * User: curso mañana
 * Date: 14/11/2016
 * Time: 11:34
 */