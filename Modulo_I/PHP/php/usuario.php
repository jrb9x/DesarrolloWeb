<?php
class usuario{
	
	public $name; 
	public $email;
	public $fecha;
	public $passw="password";

	const HOMBRE= "H";
	const MUJER = "M";
	const MAYORIA_EDAD = 18;
	

	public function edad(){
		$date1 = new DateTime($this->fecha);
		$date2 = new DateTime('now');
		$interval = $date1->diff($date2);
		$edad = $interval->format('%Y');
		return $edad;
	}
	
	public function Login($passw){
		if($passW == $passU){
			return true;
		}else
			return false;
	}
	
	public function toString(){
		$string = "<table>
		<tr>
			<td rowspan='6'>mostrarImagen()</td>
			<td class='rotulo'>Nombre de Usuario: </td>
			<td>$name</td>
		</tr>
		<tr>
			<td class='rotulo'>Email: </td>
			<td>$email</td>
		</tr>
		<tr>
			<td class='rotulo'>Edad: </td>
			<td>$age</td>
		</tr>
		<tr>
			<td class='rotulo'>contraseña: </td>
			<td>$pass</td>
		</tr>
		<tr>
			<td class='rotulo'>Sexo: </td>
			<td>$gender</td>
		</tr>
		<tr>
			<td class='rotulo'>Intereses: </td>
			<td>$int1 $int2 $int3 $int4</td>
		</tr>
	<table>";
	}
}


?>