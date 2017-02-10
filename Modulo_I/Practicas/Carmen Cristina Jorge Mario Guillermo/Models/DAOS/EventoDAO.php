<?php

require_once ("UtilDB.php");

class EventoDAO
{
    public function insert($evento)
    {
        $dbConnection = UtilDB::connectTo("ccoo","root","");

        $query = $dbConnection->prepare("INSERT INTO eventos(cupo,descripcion,duracion,fechaInicio,fechaFin,hora,lugar,tipo,fechaModificacion) VALUES(:cupo,:descripcion,:duracion,:fechaInicio,:fechaFin,:hora,:lugar,:tipo,:fechaModificacion)");

        $query->bindParam(":tipo", $evento->getTipo());
        $query->bindParam(":fechaInicio", $evento->getFechaInicio());
        $query->bindParam(":hora", $evento->getHora());
        $query->bindParam(":fechaFin", $evento->getFechaFin());
        $query->bindParam(":duracion", $evento->getDuracion());
        $query->bindParam(":lugar", $evento->getLugar());
        $query->bindParam(":descripcion", $evento->getDescripcion());
        $query->bindParam(":cupo", $evento->getCupo());
        $query->bindParam(":fechaModificacion", $evento->getFechaModificacion()->format('Y-m-d H:i:s'));

        $query->execute();
    }
    public function selectAll()
    {
        $dbConnection = UtilDB::connectTo("ccoo", "root", "");
        $query = $dbConnection->prepare('SELECT * FROM eventos');

        $query->execute();
        return $query->fetchAll(PDO::FETCH_ASSOC);
    }
}