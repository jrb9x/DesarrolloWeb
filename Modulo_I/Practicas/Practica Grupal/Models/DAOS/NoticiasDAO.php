<?php
require_once ("../Beans/Noticias.php");
require_once("UtilDB.php");

class NoticiasDAO
{
    public function insert($noticias)
    {
      $dbConnection = UtilDB::connectTo("CCOO","root","");
      $query = $dbConnection->prepare("INSERT INTO noticias (titulo, subtitulo, cuerpo, imagen, pieImagen, imagenMiniatura, fehaCreacion, fechaModificaion)
                                      VALUES(
                                             :titulo,
                                             :subtitulo,
                                             :cuerpo,
                                             :imagen,
                                             :pieImagen,
                                             :imagenMiniatura,
                                             :fehaCreacion,
                                             :fechaModificaion)");
        $query->bindParam(":titulo", $noticias->getTitulo());
        $query->bindParam(":subtitulo", $noticias->getSubtitulo());
        $query->bindParam(":cuerpo", $noticias->getCuerpo());
        $query->bindParam(":imagen", $noticias->getImagen());
        $query->bindParam(":pieImagen", $noticias->getPieImagen());
        $query->bindParam(":imagenMiniatura", $noticias->getImagenMiniatura());
        $query->bindParam(":fehaCreacion", $noticias->getFechaCreacion()->format('Y-m-d H:i:s'));
        $query->bindParam(":fechaModificaion", $noticias->getFechaModificacion()->format('Y-m-d H:i:s'));

        $query->execute();
    }
    public function selectAll()
    {
        $dbConnection = UtilDB::connectTo("ccoo", "root", "");
        $query = $dbConnection->prepare('SELECT * FROM noticias');

        $query->execute();
        return $query->fetchAll(PDO::FETCH_ASSOC);
    }
}

/**
 * Created by PhpStorm.
 * User: curso mañana
 * Date: 14/11/2016
 * Time: 11:55
 */