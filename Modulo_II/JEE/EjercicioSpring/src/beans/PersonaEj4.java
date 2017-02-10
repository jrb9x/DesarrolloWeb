package beans;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class PersonaEj4 implements Serializable {

	private String nombre; 
	private int edad; 
	private float altura; 
	private Direccion direccion;
	
	public PersonaEj4() {
		super();
	}
	
	public PersonaEj4(String nombre, int edad, float altura, Direccion direccion) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.altura = altura;
		this.direccion = direccion;
	}
	
	public PersonaEj4(Direccion direccion){
		this.direccion= direccion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public float getAltura() {
		return altura;
	}
	
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	public Direccion getDireccion() {
		return direccion;
	}
	
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	

}
