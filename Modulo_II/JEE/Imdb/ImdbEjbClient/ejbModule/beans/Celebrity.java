package beans;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Celebrity {
	@Id
	@GeneratedValue
	private Integer id; 
	private String nombre;
	private String apellidos;
	private String nacionalidad;
	private LocalDate fechaNacimiento;
	private boolean actor;
	private boolean director;
	@ManyToMany
	private List<Pelicula> listaPeliculas;
	private String rutaFoto;
	
	public Celebrity(){
		
	}
	

	public Celebrity(String nombre, String apellidos, String nacionalidad, LocalDate fechaNacimiento, boolean actor,
			boolean director, List<Pelicula> listaPeliculas, String rutaFoto) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
		this.actor = actor;
		this.director = director;
		this.listaPeliculas = listaPeliculas;
		this.rutaFoto = rutaFoto;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public boolean isActor() {
		return actor;
	}

	public void setActor(boolean actor) {
		this.actor = actor;
	}

	public boolean isDirector() {
		return director;
	}

	public void setDirector(boolean director) {
		this.director = director;
	}

	public List<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}

	public void setListaPeliculas(List<Pelicula> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}
	
	public String getRutaFoto(){
		return rutaFoto;
	}
	
	public void setRutaFoto(String rutaFoto){
		this.rutaFoto = rutaFoto;
	}

	
}
