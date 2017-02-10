<?php

class Eventos
{
    private $idEvento;
    private $tipo;
    private $fechaInicio;
    private $hora;
    private $fechaFin;
    private $duracion;
    private $lugar;
    private $descripcion;
    private $cupo;
    private $fechaModificación;

    public function getTipo()
    {
        return $this->tipo;
    }

    public function setTipo($tipo)
    {
        $this->tipo = $tipo;
    }

    public function getCupo()
    {
        return $this->cupo;
    }

    public function setCupo($cupo)
    {
        $this->cupo = $cupo;
    }

    public function getDescripcion()
    {
        return $this->descripcion;
    }

    public function setDescripcion($descripcion)
    {
        $this->descripcion = $descripcion;
    }

    public function getDuracion()
    {
        return $this->duracion;
    }

    public function setDuracion($duracion)
    {
        $this->duracion = $duracion;
    }

    public function getFechaFin()
    {
        return $this->fechaFin;
    }

    public function setFechaFin($fechaFin)
    {
        $this->fechaFin = $fechaFin;
    }

    public function getFechaInicio()
    {
        return $this->fechaInicio;
    }

    public function setFechaInicio($fechaInicio)
    {
        $this->fechaInicio = $fechaInicio;
    }

    public function getFechaModificación()
    {
        return $this->fechaModificación;
    }

    public function setFechaModificación($fechaModificación)
    {
        $this->fechaModificación = $fechaModificación;
    }

    public function getHora()
    {
        return $this->hora;
    }

    public function setHora($hora)
    {
        $this->hora = $hora;
    }

    public function getIdEvento()
    {
        return $this->idEvento;
    }

    public function getLugar()
    {
        return $this->lugar;
    }

    public function setLugar($lugar)
    {
        $this->lugar = $lugar;
    }
}