<?php

require_once ("UtilDB.php");

class SolicitudDelegadosDAO
{
    public function insert($solicitudDelegados)
    {
        $dbConnection = UtilDB::connectTo("CCOO","root","");
        $query = $dbConnection->prepare("INSERT INTO solicituddelegados(nombre, apellidos, telefono, email, razon)
                                      VALUES(
                                            :nombre,
                                            :apellidos,
                                            :telefono,
                                            :email,
                                            :razon)");
        $query->bindParam(":nombre", $solicitudDelegados->getNombre());
        $query->bindParam(":apellidos", $solicitudDelegados->getApellidos());
        $query->bindParam(":telefono", $solicitudDelegados->getTelefono());
        $query->bindParam(":email", $solicitudDelegados->getEmail());
        $query->bindParam(":razon", $solicitudDelegados->getRazon());

        //TODO other bindParams()
        $query->execute();
    }
    public function selectAll()
    {
        $dbConnection = UtilDB::connectTo("ccoo", "root", "");
        $query = $dbConnection->prepare('SELECT * FROM solicituddelegados');

        $query->execute();
        return $query->fetchAll(PDO::FETCH_ASSOC);
    }
}
/**
 * Created by PhpStorm.
 * User: curso mañana
 * Date: 14/11/2016
 * Time: 12:02
 */