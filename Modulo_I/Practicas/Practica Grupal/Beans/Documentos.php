<?php

class Documentos
{
    private $idDocumentos;
    private $titulo;
    private $descripcion;
    private $fechaPublicacion;
    private $archivo;
    private $privado;//BOOLEAN
    private $ley;//BOOLEAN
    private $fechaModificacion;

    /**
     * GET
     */

    public function getIdDocumentos()
    {
        return $this->idDocumentos;
    }

    public function getTitulo()
    {
        return $this->titulo;
    }

    public function getDescripcion()
    {
        return $this->descripcion;
    }

    public function getFechaPublicacion()
    {
        return $this->fechaPublicacion;
    }

    public function getArchivo()
    {
        return $this->archivo;
    }

    public function getPrivado()
    {
        return $this->privado;
    }

    public function getLey()
    {
        return $this->ley;
    }

    public function getFechaModificacion()
    {
        return $this->fechaModificacion;
    }

    /**
     * SET
     */

    public function setTitulo($titulo)
    {
        $this->titulo = $titulo;
    }

    public function setDescripcion($descripcion)
    {
        $this->descripcion = $descripcion;
    }

    public function setFechaPublicacion($fechaPublicacion)
    {
        $this->fechaPublicacion = $fechaPublicacion;
    }

    public function setArchivo($archivo)
    {
        $this->archivo = $archivo;
    }

    public function setPrivado($privado)
    {
        $this->privado = $privado;
    }

    public function setLey($ley)
    {
        $this->ley = $ley;
    }

    public function setFechaModificacion($fechaModificacion)
    {
        $this->fechaModificacion = $fechaModificacion;
    }
}