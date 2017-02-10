<?php

class Usuario{

	private $nombre;
	private $password;
	
	function __construct($nombre,$password){

		$this->nombre=$nombre;
		$this->password=$password;
	}
	

	function getNombre(){
		return $this->nombre;
	}
	function getPassword(){
		return $this->password;
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
}

?>