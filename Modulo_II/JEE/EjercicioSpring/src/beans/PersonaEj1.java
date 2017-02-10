package beans;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class PersonaEj1 implements Serializable {
	
	private Long id; 
	private String nombre; 
	private String apellidos;
	private Direccion direccion;
	
	public PersonaEj1() {
		super();
	}
	

	public PersonaEj1(Long id, String nombre, String apellidos, Direccion direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
