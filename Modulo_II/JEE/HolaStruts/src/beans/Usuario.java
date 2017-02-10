package beans;

import java.util.Date;

public class Usuario {

	
	private String nombre;
	private String email;
	private String passw;
	private String passw2;
	private Date fechaNacimiento;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassw() {
		return passw;
	}
	public void setPassw(String passw) {
		this.passw = passw;
	}
	public String getPassw2() {
		return passw2;
	}
	public void setPassw2(String passw2) {
		this.passw2 = passw2;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", email=" + email + ", passw=" + passw + ", passw2=" + passw2
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
}
