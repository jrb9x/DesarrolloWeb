<?php

	require("class.database.php");
	require("usuario.php");
	
	class UsuarioDAO{
		
		private $mysqli;
		
		function __construct(){
			
			$db = Database::getInstance();
			$this->mysqli = $db->getConnection();
		}
		
		function registrarUsuario($usuario){
			$query="insert into usuarios values (?,?,?,?)";
			$stm= $this->mysqli->stmt_init();
			$stm->prepare($query);
			$stm->bind_param("ssss",$usuario->getNombre(),$usuario->getPassword(),$usuario->getEstado(),$usuario->getRutaImagen());
			$stm->execute();
			$stm->close();
		}
		
		function recuperarUsuario($nombre){
			$query='select * from usuarios where nombre ="'.$nombre.'"';
			$result = $this->mysqli->query($query);
			$fila = $result -> fetch_assoc();
			if (count($fila)>0){
				$usuario = new Usuario(
				$fila['nombre'],
				$fila['password'],
				$fila['estado'],
				$fila['imagen']);
				return $usuario;
			}else{
				return false;
			}
		}
		
		function actualizarUsuario($usuario){
			$query= "UPDATE usuarios SET estado = '".$usuario->getEstado() 
					."' WHERE nombre='". $usuario->getNombre() ."';";
			return $this->mysqli->query($query);			
			
		}
		
		function recuperarSeguidosPor($nombre){
			/*
			$query='select usuarios.nombre , usuarios.estado, usuarios.imagen 
			from usuarios,  seguir  
			where usuarios.nombre = seguir.usuario
			and seguir.seguidor="'.$nombre.'"';
			*/
			$query= "select usuario from seguir 
			where seguidor='".$nombre."'";
			$result = $this->mysqli->query($query);
			$usuarios = Array();
			while($fila = $result -> fetch_assoc()){
			$usuarioSeguido= $this->recuperarUsuario($fila["usuario"]);
			$usuarios[]=($usuarioSeguido);
			}
			return $usuarios;
		}
	}

?>