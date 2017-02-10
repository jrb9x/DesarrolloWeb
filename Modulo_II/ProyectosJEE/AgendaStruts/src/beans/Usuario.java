package beans;

import java.util.List;

import javax.persistence.*;

@Entity
public class Usuario {
	@Id
	private String nombre;
	private String passw;
	@OneToMany
	private List<Contacto> contacto;
	
	public Usuario(){}

	
	public Usuario(String nombre, String passw) {
		super();
		this.nombre = nombre;
		this.passw = passw;
		
	}	
	
	public List<Contacto> getContacto() {
		return contacto;
	}


	public void setContacto(List<Contacto> contacto) {
		this.contacto = contacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassw() {
		return passw;
	}

	public void setPassw(String passw) {
		this.passw = passw;
	}


}
