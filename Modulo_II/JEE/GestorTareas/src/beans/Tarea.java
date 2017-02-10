package beans;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Tarea implements Serializable {
	@Id
	@GeneratedValue
	private Integer id;
	private String nombre;
	private boolean realizada;
	private LocalDate fecha;
	@OneToOne
	private Usuario usuario;
	
	public Tarea(){}
	
	public Tarea(String nombre){
		super();
		this.nombre = nombre;
	}

	public Tarea(Integer id, String nombre, boolean realizada, LocalDate fecha, Usuario usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.realizada = realizada;
		this.fecha = fecha;
		this.usuario = usuario;
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

	public boolean isRealizada() {
		return realizada;
	}

	public void setRealizada(boolean realizada) {
		this.realizada = realizada;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
}
