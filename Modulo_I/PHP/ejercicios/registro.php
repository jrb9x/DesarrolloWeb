<!DOCTYPE html>
<html>
<head>
	<title>Registrar Formulario</title>
	<meta charset="utf-8">
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


$dir_subida = './uploads/';
$fichero_subido = $dir_subida . $name.".jpg";

echo "<table>
		<tr>
			<td rowspan='6'>";
			if (move_uploaded_file($_FILES['imagen']['tmp_name'], $fichero_subido)) { 
				echo "<img src= $fichero_subido width='150px' height='150px'>";
			} 
			else { 
				echo "¡Posible ataque de subida de ficheros!\n"; 
			} 
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

?>
</section>

</main>
</body>
</html>

