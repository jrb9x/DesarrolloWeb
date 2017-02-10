package beans;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class PersonaEj2 {

	private String nombre; 
	private int edad; 
	private float altura; 
	private PersonaEj2 pareja; 
	private List<PersonaEj2> amigos; 
	private List<String> colores; 
	private Map<String,String> emails;
	
	public PersonaEj2() {
		super();
	}
	

	public PersonaEj2(String nombre, int edad, float altura, PersonaEj2 pareja, List<PersonaEj2> amigos, List<String> colores,
			Map<String, String> emails) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.altura = altura;
		this.pareja = pareja;
		this.amigos = amigos;
		this.colores = colores;
		this.emails = emails;
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

	public PersonaEj2 getPareja() {
		return pareja;
	}

	public void setPareja(PersonaEj2 pareja) {
		this.pareja = pareja;
	}

	public List<PersonaEj2> getAmigos() {
		return amigos;
	}

	public void setAmigos(List<PersonaEj2> amigos) {
		this.amigos = amigos;
	}

	public List<String> getColores() {
		return colores;
	}

	public void setColores(List<String> colores) {
		this.colores = colores;
	}

	public Map<String, String> getEmails() {
		return emails;
	}

	public void setEmails(Map<String, String> emails) {
		this.emails = emails;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	} 
	
	
}
