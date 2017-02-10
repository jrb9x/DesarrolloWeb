<?php

class Noticias
{
    private $idNoticia;
    private $titulo;
    private $subtitulo;
    private $cuerpo;
    private $imagen;
    private $pieImagen;
    private $imagenMiniatura;
    private $fechaCreación;
    private $fechaModificacion;

    public function getCuerpo()
    {
        return $this->cuerpo;
    }


    public function setCuerpo($cuerpo)
    {
        $this->cuerpo = $cuerpo;
    }

    public function getImagen()
    {
        return $this->imagen;
    }

    public function setImagen($imagen)
    {
        $this->imagen = $imagen;
    }

    public function getSubtitulo()
    {
        return $this->subtitulo;
    }

    public function setSubtitulo($subtitulo)
    {
        $this->subtitulo = $subtitulo;
    }

    public function getTitulo()
    {
        return $this->titulo;
    }

    public function setTitulo($titulo)
    {
        $this->titulo = $titulo;
    }

    public function getFechaCreación()
    {
        return $this->fechaCreación;
    }

    public function setFechaCreación($fechaCreación)
    {
        $this->fechaCreación = $fechaCreación;
    }

    public function getFechaModificacion()
    {
        return $this->fechaModificacion;
    }

    public function setFechaModificacion($fechaModificacion)
    {
        $this->fechaModificacion = $fechaModificacion;
    }

    public function getIdNoticia()
    {
        return $this->idNoticia;
    }

    public function setIdNoticia($idNoticia)
    {
        $this->idNoticia = $idNoticia;
    }

    public function getImagenMiniatura()
    {
        return $this->imagenMiniatura;
    }

    public function setImagenMiniatura($imagenMiniatura)
    {
        $this->imagenMiniatura = $imagenMiniatura;
    }

    public function getPieImagen()
    {
        return $this->pieImagen;
    }

    public function setPieImagen($pieImagen)
    {
        $this->pieImagen = $pieImagen;
    }
}