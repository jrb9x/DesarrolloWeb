<!DOCTYPE html>
<html>
<head>
	<title>Registrar Formulario</title>
	<meta charset="utf-8">
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
	background:linear-gradient(to bottom, #FFFFFF, #A2DEFF);
}
	</style>
</head>

<body>
<main>
<header>
	<h2>Formulario de Registro</h2>
</header>
<section>
<form ENCTYPE="multipart/form-data" action="registro.php" method="POST" name="login">
	<table>	
		<tr>
			<td class="rotulo">Nombre de Usuario: </td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td class="rotulo">Email: </td>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td class="rotulo">Fecha de Nacimiento: </td>
			<td><input type="date" name="age"></td>
		</tr>
		<tr>
			<td class="rotulo">contraseña: </td>
			<td><input type="password" name="pass"></td>
		</tr>
		<tr>
			<td class="rotulo">Sexo: </td>
			<td>
				<input type="radio" name="gender" value="male" checked>Hombre
				<input type="radio" name="gender" value="female">Mujer
			</td>
		</tr>
		<tr>
			<td class="rotulo">Intereses: </td>
			<td>
				<input type="checkbox" name="int1" value="HTML5">HTML5
				<input type="checkbox" name="int2" value="PHP">PHP
				<input type="checkbox" name="int3" value="JAVASCRIPT">JAVASCRIPT
				<input type="checkbox" name="int4" value="JAVA">JAVA
				
			</td>
		</tr>
<table>
Subir imagen: <INPUT NAME="imagen" TYPE="file"><br>
<input type="submit" value="Registro">
</form>
</section>

</main>
</body>
</html>