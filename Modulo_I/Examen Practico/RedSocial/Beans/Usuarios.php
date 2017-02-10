<?php

class Usuarios
{
    private $nombre;
    private $password;
    private $imagen;
    private $estado;

    /**
     * GET
     */
    public function getNombre()
    {
        return $this->nombre;
    }

    public function getPassword()
    {
        return $this->password;
    }

    public function getImagen()
    {
        return $this->imagen;
    }

    public function getEstado()
    {
        return $this->estado;
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

    public function setImagen($imagen)
    {
        $this->imagen = $imagen;
    }

    public function setEstado($estado)
    {
        $this->estado = $estado;
    }
}