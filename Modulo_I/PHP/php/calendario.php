<!DOCTYPE html>
<html>
<body>
<form action="calendario.php" method="GET" name="calendario">
Mes a mostrar: <input name="mes" type="number">
<input type="submit" value="Mes">

</form>
<table>
<?php
error_reporting(0);
$nombreDias= array("Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo");
$mesesDias=array("Enero"=>31,"Febrero"=>28,"Marzo"=>31,"abril"=>30,"Mayo"=>31,"Junio"=>30,"Julio"=>31,"Agosto"=>31,"Septiembre"=>30,"Octubre"=>31,"Noviembre"=>30,"Diciembre"=>31);
$meses=array("Enero","Febrero","Marzo","abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre");
$primerDia=6;
$mesSolicitado=0;
$mesSolicitado=$_GET['mes'];

//Imprimo las cabeceras
echo "<tr>";
foreach($nombreDias as $dia){ 
	echo "<th>$dia</th>";
}
echo "</tr>";
/************************************/

if($mesSolicitado == 0){ //Si es Enero pintamos y ya está
	pintarMes($primerDia,$meses[0]);
}
/**************************************/
foreach($mesesDias as $mes => $diasMes){ // Si no es enero, tenemos que calcular su primer día
		$primerDiaSiguienteMes=(($diasMes%7)+$primerDia)%7; //Calculamos el primer día del mes siguiente
		if(strcmp($mes,$meses[$mesSolicitado-1])==0){ //Si el mes siguiente es el que queremos imprimir
		pintarMes($primerDiaSiguienteMes,$meses[$mesSolicitado]); //lo imprimimos
		}
		$primerDia=$primerDiaSiguienteMes; //si no pasamos al siguiente mes.
		}

/***************************************/

function pintarMes($primerDiaMes, $mes){
	global $mesesDias;
	echo "<caption>$mes</caption>";
	echo "<tr>";
		for($i=0;$i<$primerDiaMes;$i++){
			echo "<td> </td>";
		}
		for($j=$primerDiaMes,$x=1;$x<=$mesesDias[$mes];$x++ ,$j++){
			echo "<td> $x </td>";
			if($j==6){
				echo "</tr>";
				$j=-1;
			if($x<$mesesDias[$mes]-6){
				echo "<tr>";
			}
			}
}
}
?>
</table>
</body>
</html>