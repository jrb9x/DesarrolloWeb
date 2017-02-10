<!DOCTYPE html>
<html>
<head>
	<title>Registrar Formulario</title>
	<meta charset="utf-8">
	<style>
	h2{text-align:center;
		color:blue;}
	table{width:100%;
		text-align:center;
		border:5px solid red;
		background:linear-gradient(to bottom, #000000, blue);
		color:#FFFFFF;}
	main{width:900px;
		margin:5px auto;}
	</style>
</head>
<body>
<main>

<?PHP

$cont = 0;
if ($gestor = opendir('./uploads')) {
	echo "<h2>Perfiles de Usuarios</h2>
		<table><tr>";
	
	while (false !== ($entrada = readdir($gestor))) {
		if ($entrada != "." && $entrada != "..") {
			$nombre = explode(".", $entrada);
            echo "<td>$nombre[0]<br>
				<img src='./uploads/$entrada' width='150px' height='150px'></td>";
			$cont++;
			if($cont>=4){
				echo "</tr><tr>";
				$cont=0;
			}
        }
	}
	echo "</tr></table>";
	closedir($gestor);
}

?>
<main>
</body>
</html>