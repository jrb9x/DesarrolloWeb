<?php


class Solicitud
{
    private $idSolicitudes;
    private $nombre;
    private $apellidos;
    private $email;
    private $telefono;
    private $razon;

    /**
     * GET
     */

    public function getIdSolicitudes()
    {
        return $this->idSolicitudes;
    }
    public function getNombre()
    {
        return $this->nombre;
    }
    public function getApellidos()
    {
        return $this->apellidos;
    }

    public function getRazon()
    {
        return $this->razon;
    }

    public function getEmail()
    {
        return $this->email;
    }
    public function getTelefono()
    {
        return $this->telefono;
    }

    /**
     * SET
     */

    public function setNombre($nombre)
    {
        $this->nombre = $nombre;
    }

    public function setApellidos($apellidos)
    {
        $this->apellidos = $apellidos;
    }

    public function setRazon($razon)
    {
        $this->razon = $razon;
    }

    public function setEmail($email)
    {
        $this->email = $email;
    }

    public function setTelefono($telefono)
    {
        $this->telefono = $telefono;
    }

}