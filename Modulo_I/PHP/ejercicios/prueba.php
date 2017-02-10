<?php
	
	$fecha=('1965/11/08');

	$date1 = new DateTime($fecha);
	$date2 = new DateTime('now');
	$interval = $date1->diff($date2);
	$edad = $interval->format('%Y');
	echo $edad;

?>