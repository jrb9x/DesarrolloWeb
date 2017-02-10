package ArrayList;
public class Persona {
	
	private String nombre;
	private String apellidos;
	private String dni;
	private int telefono;
	private Fecha fecha;
	
	public Persona(String nombre, String apellidos, String dni, int telefono, Fecha fecha) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.telefono = telefono;
		this.fecha = fecha;
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

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}
	
	public int edadActual(){
		int dHoy = 1, mHoy = 12,aHoy = 2016;
		int edad = aHoy - this.fecha.getAnio();
		mHoy = mHoy - this.fecha.getMes();
		dHoy = dHoy - this.fecha.getDia();
		if(mHoy < 0)
			edad -= 1;
		else if(mHoy == 0){
			if(dHoy < 0)
				edad -= 1;
		}
		return edad;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + " " + apellidos + "\n dni: " + dni + "\n telefono: " + telefono + "\n Edad: " + edadActual() + " años";
	}
	
}
