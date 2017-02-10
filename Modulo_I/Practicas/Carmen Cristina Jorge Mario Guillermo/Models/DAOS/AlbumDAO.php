<?php
require_once("UtilDB.php");
class AlbumDAO
{
    public function insert($album)
    {
        $dbConnection = UtilDB::connectTo("ccoo","root","");

        $query = $dbConnection->prepare("INSERT INTO album(titulo, imagenes, fechaModificacion, arrayMultimedia) VALUES(:titulo, :imagenes, :fechaModificacion, :arrayMultimedia)");

        $query->bindParam(":titulo", $album->getTitulo());
        $query->bindParam(":imagenes",$album->getImagen());
        $query->bindParam(":fechaModificacion", $album->getFechaModificacion()->format('Y-m-d H:i:s'));
        $query->bindParam(":arrayMultimedia", $album->getArrayMultimedia());

        $query->execute();
    }
    public function selectAll()
    {
        $dbConnection = UtilDB::connectTo("ccoo", "root", "");
        $query = $dbConnection->prepare('SELECT * FROM album');

        $query->execute();
        return $query->fetchAll(PDO::FETCH_ASSOC);
    }
}