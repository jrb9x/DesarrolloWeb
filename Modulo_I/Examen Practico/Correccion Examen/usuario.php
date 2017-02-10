<?php

class Usuario{

	private $nombre;
	private $password;
	private $estado;
	private $rutaImagen;
	
	function __construct($nombre,$password,$estado,$rutaImagen){

		$this->nombre=$nombre;
		$this->password=$password;
		$this->estado=$estado;
		$this->rutaImagen=$rutaImagen;
	}
	

	function getNombre(){
		return $this->nombre;
	}
	function getPassword(){
		return $this->password;
	}
	function getEstado(){
		return $this->estado;
	}
	function getRutaImagen(){
		return $this->rutaImagen;
	}
	function setEstado($estado){
		$this->estado=$estado;
	}
}

?>