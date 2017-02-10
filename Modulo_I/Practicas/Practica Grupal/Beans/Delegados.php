<?php

class Delegados
{
    private $idDelegados;
    private $usuario;
    private $password;
    private $nombre;
    private $apellidos;

    /**
     * GET
     */

    public function getIdDelegados()
    {
        return $this->idDelegados;
    }

    public function getNombre()
    {
        return $this->nombre;
    }

    public function getPassword()
    {
        return $this->password;
    }

    public function getUsuario()
    {
        return $this->usuario;
    }

    public function getApellidos()
    {
        return $this->apellidos;
    }

    /**
     * SET
     */

    public function setNombre($nombre)
    {
        $this->nombre = $nombre;
    }

    public function setPassword($password)
    {
        $this->password = $password;
    }

    public function setUsuario($usuario)
    {
        $this->usuario = $usuario;
    }

    public function setApellidos($apellidos)
    {
        $this->apellidos = $apellidos;
    }

}