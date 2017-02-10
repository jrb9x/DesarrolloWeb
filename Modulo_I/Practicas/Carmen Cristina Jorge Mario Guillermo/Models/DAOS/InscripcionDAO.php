<?php

require_once("../../Beans/Eventos.php");
require_once ("UtilDB.php");

class InscripcionDAO
{
    public function insert($inscripcion)
    {
        $dbConnection = UtilDB::connectTo("CCOO","root","");
        $query = $dbConnection->prepare("INSERT INTO inscripciones(id_evento, nombre, apellido, email, telefono)
                                      VALUES(                                           
                                            :id_evento,
                                            :nombre,
                                            :apellido,
                                            :email,
                                            :telefono)");
        $query->bindParam(":id_evento", $inscripcion->getIdEvento());
        $query->bindParam(":nombre", $inscripcion->getNombre());
        $query->bindParam(":apellido", $inscripcion->getApellidos());
        $query->bindParam(":email", $inscripcion->getEmail());
        $query->bindParam(":telefono", $inscripcion->getTelefono());

        $query->execute();
    }
    public function selectAll()
    {
        $dbConnection = UtilDB::connectTo("ccoo", "root", "");
        $query = $dbConnection->prepare('SELECT * FROM inscripciones');

        $query->execute();
        return $query->fetchAll(PDO::FETCH_ASSOC);
    }
}