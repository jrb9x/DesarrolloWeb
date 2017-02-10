<?php

require_once ("UtilDB.php");

class DocumentosDAO
{
    public function insert($documentos)
    {
        $dbConnection = UtilDB::connectTo("CCOO","root","");
        $query = $dbConnection->prepare("INSERT INTO documentacion(titulo, descripcion, fechaPublicacion, archivo, privado, ley, fechaModificacion)
                                      VALUES(                                           
                                            :titulo,
                                            :descripcion,
                                            :fechaPublicacion,
                                            :archivo,
                                            :privado, 
                                            :ley, 
                                            :fechaModificacion)");
        $query->bindParam(":titulo", $documentos->getTitulo());
        $query->bindParam(":descripcion", $documentos->getDescripcion());
        $query->bindParam(":fechaPublicacion", $documentos->getFechaPublicacion());
        $query->bindParam(":archivo", $documentos->getArchivo());
        $query->bindParam(":privado", $documentos->getPrivado());
        $query->bindParam(":ley", $documentos->getLey());
        $query->bindParam(":fechaModificacion", $documentos->getFechaModificacion()->format("Y-m-d H:i:s"));
        //TODO other bindParams()
        $query->execute();
    }
    public function selectAll()
    {
        $dbConnection = UtilDB::connectTo("ccoo", "root", "");
        $query = $dbConnection->prepare('SELECT * FROM documentacion ORDER BY fechaPublicacion DESC');

        $query->execute();
        return $query->fetchAll(PDO::FETCH_ASSOC);
    }
}
/**
 * Created by PhpStorm.
 * User: curso mañana
 * Date: 14/11/2016
 * Time: 12:57
 */