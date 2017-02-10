<?php

class Inscripciones
{
    private $idEvento;
    private $nombre;
    private $apellidos;
    private $email;
    private $telefono;

    public function getIdEvento()
    {
        return $this->idEvento;
    }

    public function setApellidos($apellidos)
    {
        $this->apellidos = $apellidos;
    }

    public function getApellidos()
    {
        return $this->apellidos;
    }

    public function setEmail($email)
    {
        $this->email = $email;
    }

    public function getEmail()
    {
        return $this->email;
    }

    public function setIdEvento($idEvento)
    {
        $this->idEvento = $idEvento;
    }

    public function getNombre()
    {
        return $this->nombre;
    }

    public function setNombre($nombre)
    {
        $this->nombre = $nombre;
    }

    public function getTelefono()
    {
        return $this->telefono;
    }

    public function setTelefono($telefono)
    {
        $this->telefono = $telefono;
    }
}