<!DOCTYPE html>
<html>
<head>
	<title>Registrar Formulario</title>
	<meta charset="utf-8">
	<!--
	<style>
*{
	font-family:verdana, arial;
	
	margin:2px;
}

body{
	
	text-align:center;
}


header{
	width:750px;
	height:60px;
	text-align:center;
	
}
table{
	width:100%;
}
main
{	
	width:800px;
	text-align:left;
	font-size:12px;
	margin:5px auto;
}

section{
	width:750px;
	clear:both;
	border:3px double #000000;
	padding:10px;
	background:linear-gradient(to bottom, #FFFFFF, #A2DEFF);;
}
	</style>-->
</head>

<body>
<main>
<header>
	<h2>Formulario de Registro</h2>
</header>
<section>

<?php

error_reporting(0);
$name=$_POST['name'];
$email=$_POST['email'];
$age=$_POST['age'];
$pass=$_POST['pass'];
$gender=$_POST['gender'];
$int1 = $_POST['int1'];
$int2 = $_POST['int2'];
$int3 = $_POST['int3'];
$int4 = $_POST['int4'];

//$objtUsuario= new Usuario();
$error = array();

$dir_subida = './uploads/';
$fichero_subido = $dir_subida . $name.".jpg";

//funcion subida de imagen correcta
function mostrarImagen(){
	if (move_uploaded_file($_FILES['imagen']['tmp_name'], $fichero_subido)) { 
		echo "<img src= $fichero_subido width='150px' height='150px'>";
	} 
	else { 
		echo "¡Posible ataque de subida de ficheros!\n"; 
	} 
}

//Comprobaciones de registro
//pass > 6
function comprobarContr($pass){
	if(strlen($pass)<6){
		$txt = "La contraseña debe tener mas de 6 caracteres";
		$array_push($error,$txt);
		return false;
	}else
		return true;
}
//edad 1 - 120
function comprobarEdad($age){
	if( $age <= 1 || $age >= 120 ){
		
		$array_push($error,"Edad comrendidad entre 1 y 120");
		return false;
	}else
		return true;
}
//email@
function comprobarEmail($email){
	if (filter_var($email, FILTER_VALIDATE_EMAIL)) {
    //Esta dirección de correo ($email) es válida
	return true;
	}
	else{
		$txt = "El Email tiene un formato invalido";
		$array_push($error,$txt);
		return false;
	}
}
//nombre
function comprobarNombre($name){
	if($name==""){
		$txt = "Debe introducir un nombre de usuario";
		$array_push($error,$txt);
		return false;
	}else
		return true;
}
//llamada a funciones para la comprobacion
$cName= comprobarNombre($name);
$cEmail= comprobarEmail($email);
$cPass= comprobarContr($pass);
//$cEdad= comprobarEdad($age);

if($cName==true && $cEmail==true && $cPass==true/* && $cEdad==true*/){
	
	echo "<table>
		<tr>
			<td rowspan='6'>";
	mostrarImagen();
	echo "</td>
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

else{
	
	echo "<table><tr><td>";
	for($i=0; $i<count($error); $i++){
		echo $error[i];
	}
	echo "</td></tr></table>";
	echo"entra";
}

?>
</section>

</main>
</body>
</html>

