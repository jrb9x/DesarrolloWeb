<?
	$semana = array('Lunes','Martes','Miercoles','Jueves','Viernes','Sabado','Domingo');
	$mes = array('Enero' => 31,
				'Febrero' => 28,
				'Marzo' => 31,
				'Abril' => 30,
				'Mayo' => 31,
				'Junio' => 30,
				'Julio' => 31,
				'Agosto' => 31,
				'Septiembre' => 30,
				'Octubre' => 31,
				'Noviembre' => 30,
				'Diciembre' => 31)
	
	function mostrarMes(){
		global $mes;
		
		define('TAM',4); //definimos la constante para el tamaño
		echo '<table border=1>'; //creamos la tabla
		
		for ($i=1; $i <= TAM; $i++){
			echo "<tr></tr>";
		
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
	}
	
?>