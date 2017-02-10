<?PHP

$archivo = fopen("e:/Datos.txt", "r");

/*if ( ! fopen("c:/Datos.txt", "w")) {
	echo "El archivo no se puede abrir";
}else{
	echo "Abierto correctamente";
}*/

/*
if ($archivo) {
	while (!feof($archivo)) {
		$linea = fgets($archivo, 255);
		echo "$linea<br>";
	}
}
fclose ($archivo)
*/
/*
if ($archivo) {
	fputs ($archivo, "\nHola Mundo");
	echo "Escrito correctamente";
}
fclose ($archivo);
*/
//copy("e:/Datos.txt", "e:/DatosCopiados.txt");

if ($gestor = opendir('..')) {
	echo "<pre>";
	echo "Gestor de directorio: $gestor\n";
	
	echo "Entradas:\n";
	/* Esta es la forma correcta de iterar sobre el directorio. */
	while (false !== ($entrada = readdir($gestor))) {
		echo "$entrada\n";
	}
	echo "</pre>";
	closedir($gestor);
}
?>
