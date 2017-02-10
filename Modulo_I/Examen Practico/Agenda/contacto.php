<?php

class Usuario{


    private $nombre;
    private $apellidos;
    private $telefono;
    private $email;
    private $direccion;


    function __construct($nombre,$apellidos,$telefono,$email,$direccion){

        $this->nombre=$nombre;
        $this->apellidos=$apellidos;
        $this->telefono=$telefono;
        $this->email=$email;
        $this->direccion=$direccion;

    }

    /**
     * GET
     */

    public function getNombre()
    {
        return $this->nombre;
    }

    public function getApellidos()
    {
        return $this->apellidos;
    }

    public function getTelefono()
    {
        return $this->telefono;
    }

    public function getEmail()
    {
        return $this->email;
    }

    public function getDireccion()
    {
        return $this->direccion;
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

    public function setTelefono($telefono)
    {
        $this->telefono = $telefono;
    }

    public function setEmail($email)
    {
        $this->email = $email;
    }

    public function setDireccion($direccion)
    {
        $this->direccion = $direccion;
    }
}

?>