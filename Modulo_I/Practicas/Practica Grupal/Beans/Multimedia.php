<?php
class Multimedia
{
    //Propiedades
    private $IdMultimedia;

    private $titulo;

    private $IdAlbum;

    private $imagen; //booleand

    private $fuente;  //ruta al archivo

    private $fechaModificacion;

    //Metodos
    public function getIdMultimedia()
    {
        return $this->IdMultimedia;
    }
    public function setTitulo($titulo)
    {
        $this->titulo = $titulo;
    }
    public function getTitulo()
    {
        return $this->titulo;
    }
    public function setIdAlbum($IdAlbum)
    {
        $this->IdAlbum = $IdAlbum;
    }
    public function getIdAlbum()
    {
        return $this->IdAlbum;
    }
    public function setImagen($Imagen)
    {
        $this->imagen = $Imagen;
    }
    public function getImagen()
    {
        return $this->imagen;
    }
    public function setFuente($fuente)
    {
        $this->fuente = $fuente;
    }
    public function getFuente()
    {
        return $this->fuente;
    }
    public function setFechaModificacion($fechaModificacion)
    {
        $this->fechaModificacion = $fechaModificacion;
    }
    public function getFechaModificacion()
    {
        return $this->fechaModificacion;
    }

}