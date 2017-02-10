<?php
error_reporting(0);
require_once("usuarioDAO.php");

class Usuario
{

    const MAYORIA_EDAD = 18;

    private $nombre;
    private $email;
    private $password;
    private $fechaNac;
    private $sexo;
    private $intereses;
    private $rutaImagen;

    /**CONS&DES**/

    function __construct($nombre, $email, $password, $fechaNac, $sexo, $intereses, $nombreImagen)
    {
        $this->nombre = $nombre;
        $this->email = $email;
        $this->password = $password;
        $this->fechaNac = $fechaNac;
        $this->sexo = $sexo;
        $this->intereses = $intereses;
        $this->rutaImagen = "./userImages/" . $nombreImagen;
	

    }

    function __destruct()
    {
        /**Destructor por defecto**/
    }

    function checkEdad($fechaNac)
    {

        $fechaDate = new DateTime($fechaNac);
        $hoy = new DateTime();

        $result = $fechaDate->diff($hoy);
        $result = $result->format('%y');

        if ($result < Usuario::MAYORIA_EDAD) {
            $result = "No es mayor de edad";
        }

        return $result;
    }

    function toString()
    {

        $string = "<table><tr>
			<td rowspan='6'><img src='" . $this->rutaImagen . "'width='150px' heigth='150px'></td>
			<td>Nombre de Usuario: </td>
			<td>" . $this->nombre . "</td>
		</tr>
		<tr>
			<td> Email: </td>
			<td>" . $this->email . "</td>
		</tr>
		<tr>
			<td>Edad: </td>
			<td>" . $this->checkEdad($this->fechaNac) . "</td>
		</tr>
		<tr>
			<td>contraseña: </td>
			<td>" . $this->password . "</td>
		</tr>
		<tr>
			<td>Sexo: </td>
			<td>" . $this->sexo . "</td>
		</tr>
		<tr>
			<td>Intereses: </td>
			<td>";
			foreach ($this->intereses as $interes) {
            $string .= $interes . ",";
			$cadIntereses .= $interes . ",";
        };
		$string .= 	"</td></tr><table>";
	
		$->insertarDatos();
		
		
        return $string;
    }


    /**GETTERS**/

    public function getNombre()
    {
        return $this->nombre;
    }

    public function getEmail()
    {
        return $this->email;
    }


    public function getFechaNac()
    {
        return $this->fechaNac;
    }


    public function getIntereses()
    {
        return $this->intereses;
    }


    public function getPassword()
    {
        return $this->password;
    }

    public function getSexo()
    {
        return $this->sexo;
    }

    public function getRutaImagen()
    {
        return $this->rutaImagen;
    }

    /**SETTERS**/

    public function setNombre($nombre)
    {
        $this->nombre = $nombre;
    }

    public function setEmail($email)
    {
        $this->email = $email;
    }

    public function setFechaNac($fechaNac)
    {
        $this->fechaNac = $fechaNac;
    }

    public function setIntereses($intereses)
    {
        $this->intereses = $intereses;
    }

    public function setPassword($password)
    {
        $this->password = $password;
    }

    public function setSexo($sexo)
    {
        $this->sexo = $sexo;
    }

    public function setRutaImagen($rutaImagen)
    {
        $this->rutaImagen = $rutaImagen;
    }
}