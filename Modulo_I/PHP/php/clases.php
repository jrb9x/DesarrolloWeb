<?php
class persona{
	
	public $nombre;
	const HOMBRE="H";
	
	public function mostrarPersona(){
		echo $this -> nombre;
		self::HOMBRE;
	}
	
	public function setNombre($nombre){
		$this->nombre=$name;
	}
	public function getNombre(){
		return $this->nombre;
	}
}


persona::HOMBRE;
echo $objtPersona::HOMBRE;
$objtPersona= new Persona();
$objPersona->nombre="Jorge"://sin funcion Set
$objPersona->setNombre("Jorge");

?>