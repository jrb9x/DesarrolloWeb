package beans;
public class Persona {
	
	private int id;
	private String nombre;
	private String apellidos;
	private String dni;
	private String telefono;
	private Fecha fecha;
	
	public Persona(){}
	
	public Persona(int id,String nombre, String apellidos, String dni, String telefono, Fecha fecha) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.telefono = telefono;
		this.fecha = fecha;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Nombre completo: " + nombre + " " + apellidos + "\n dni: " + dni + "\n telefono: " + telefono + "\n Fecha de Nacimiento: " + fecha;
	}
	
	public String devolverDatos(){
		String datos, separador = "%";
		
		String nombre = this.nombre;
        String apellidos = this.apellidos;
        String dni = this.dni;
        String telefono = this.telefono;
        String fecha = this.fecha.toString();
        
        datos = nombre + separador + apellidos + separador + dni + separador + telefono + separador + fecha;
        return datos;
        
	}
	
}
