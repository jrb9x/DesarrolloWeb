package beans;

public class Usuario {
	private String nombre;
	private String passw;
	
	public Usuario(){}
	
	public Usuario(String nombre, String passw) {
		this.nombre = nombre;
		this.passw = passw;
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
