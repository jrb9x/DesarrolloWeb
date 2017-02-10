
<?php
	function potencia($i,$j){
		$b = pow($i,$j);
		return $b; 
	}
	define('TAM',4); //definimos la constante para el tamaño
	echo '<table border=1>'; //creamos la tabla
	
	for ($i=1; $i <= TAM; $i++){
		if ($i % 2 == 0) //Si la división de la variable $n1 entre dos da 0 creamos una fila gris
			echo '<tr style="background-color:#000000; color:#FFFFFF";>';
		else
			echo "<tr>"; //creamos fila blanca cuando no sea divisible entre 2
		for ($j=1; $j <= TAM; $j++){
			echo "<td>".potencia($i,$j)."</td>"; //creamos una celda y mostramos el número
		}
		echo "</tr>"; //cerramos la fila
	}
	echo "</table>"; //cerramos la tabla
	
?>
