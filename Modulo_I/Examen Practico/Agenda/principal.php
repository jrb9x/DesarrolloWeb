<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<link rel="stylesheet" href="estilos.css">
</head>
<body>
	<main>
		<header>
			AGENDA
			<div id="logout"><a href="logout.php">Logout</a></div>
		</header>
		<section>
		<?php 

		require("contactoDAO.php");
		session_start();
		$usuario= $_SESSION["usuario"];

		if($usuario){
			echo "<h1>Agenda</h1>";
			?>
			<h3>Lista de Contactos</h3>
			<table id="listaContactos">
			<?php
			$contactoDAO = new ContactoDAO();
			$array = $contactoDAO->recuperarContactos("jorge");
			foreach($array as $x) {
				echo '<tr>
					<td>' . $x->getNombre() . '</td>
					<td>' . $x->getApellidos() . ' </td>
					<td>' . $x->getTelefono() . ' </td>
					<td>' . $x->getEmail() . ' </td>
					<td>' . $x->getDireccion() . ' </td>
				</tr>';
			}
		}else{
			header("location:login.html");
		}
			?>				
			</table>
			
		</section>
		
	</main>
</body>
</html>