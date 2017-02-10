<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<link rel="stylesheet" href="estilos.css">
</head>
<body>
	<main>
		<header>
			RED SOCIAL
			<div id="logout"><a href="logout.php">Logout</a></div>
		</header>
		<section>
		<?php 
		require("usuarioDAO.php");
		session_start();
		$usuario= $_SESSION["usuario"];
		//var_dump($usuario);
		if($usuario){
		echo '<img src="'.$usuario->getRutaImagen().'" width="250px" height="250px">';
		echo 	"<h1>Tu estado es:".$usuario->getEstado()."</h1>";
			?>
			<h3>¿Tu estado ha cambiado? Cámbialo</h3>
			<form action="cambiarEstado.php" method="POST">
				<input type="textarea" name="estado" placeholder="Nuevo estado"/>
				<input type="submit" value="cambiar estado"/>
			</form>
			
		</section >
		<section id="estadoAmigos">
			<h2>Estás siguiendo a:</h2>
			<table id="tablaEstados">
			<?php
			
			
			$usuarioDAO = new UsuarioDAO();
			$array = $usuarioDAO->recuperarSeguidosPor($usuario->getNombre());
			foreach($array as $x){
				echo '<tr>
					<td><img src="'.$x->getRutaImagen().'" width="90px" height="90px"></td>
					<td>'.$x->getNombre().' </td>
					<td>'.$x->getEstado().' </td>
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