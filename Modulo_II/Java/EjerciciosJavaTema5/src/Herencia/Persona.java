package Herencia;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Persona extends Object implements Serializable{

	private String nombre,apellidos,dni;
	
	public Persona(){
		nombre = "Jorge";
		apellidos = "Rivas";
		dni = "50621534Y";
	}

	public Persona(String nombre, String apellidos, String dni) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
	}
	
	public void mostrarPersona(){
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public abstract int aniosExperiencia();
	
}
