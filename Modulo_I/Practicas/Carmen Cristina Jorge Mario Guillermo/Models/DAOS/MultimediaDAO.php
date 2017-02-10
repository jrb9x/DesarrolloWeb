<?php
require_once("UtilDB.php");
class MultimediaDAO
{
    public function insert($multimedia)
    {
        $dbConnection = UtilDB::connectTo("ccoo","root","");

        $query = $dbConnection->prepare("INSERT INTO multimedia(imagen, fuente, titulo, id_album, fechaModificacion) VALUES(:imagen, :fuente, :titulo,:id_album,:fechaModificacion)");

        $query->bindParam(":imagen",$multimedia->getImagen());
        $query->bindParam(":fuente", $multimedia->getFuente());
        $query->bindParam(":titulo", $multimedia->getTitulo());
        $query->bindParam(":id_album", $multimedia->getIdAlbum());
        $query->bindParam(":fechaModificacion", $multimedia->getFechaModificacion()->format('Y-m-d H:i:s'));

        $query->execute();
    }
    public function selectAll()
    {
        $dbConnection = UtilDB::connectTo("ccoo", "root", "");
        $query = $dbConnection->prepare('SELECT * FROM multimedia');

        $query->execute();
        return $query->fetchAll(PDO::FETCH_ASSOC);
    }
    function videosAlbum($IdAlbum){
        $dbConnection = UtilDB::connectTo("ccoo", "root", "");
        $query = $dbConnection->prepare("SELECT * FROM multimedia WHERE id_album = $IdAlbum");
        $query->execute();
        return $query->fetchAll(PDO::FETCH_ASSOC);

    }
}