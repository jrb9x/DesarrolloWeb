package com.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable {
	@Id
	private String nombre;
	private String password;
	@OneToMany
	private List<Contacto> contacto;
	
	public Usuario() {
		super();
	}
		
	public Usuario(String nombre, String password) {
		super();
		this.nombre = nombre;
		this.password = password;
	}

	public Usuario(String nombre, String password, List<Contacto> contacto) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.contacto = contacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Contacto> getContacto() {
		return contacto;
	}

	public void setContacto(List<Contacto> contacto) {
		this.contacto = contacto;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", password=" + password + "]";
	}
	
}
