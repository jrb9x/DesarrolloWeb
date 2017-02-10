package beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Usuario {
	@Id
	@GeneratedValue
	private Integer id;
	private String nombre;
	private String password;
	@ManyToMany(cascade=CascadeType.ALL,targetEntity=Pelicula.class)
	private List<Pelicula> listaPeliculasFavoritas;
	
	public Usuario(){
		
	}
	
	public Usuario(String nombre, String password, List<Pelicula> listaPeliculasFavoritas) {
		this.nombre = nombre;
		this.password = password;
		this.listaPeliculasFavoritas = listaPeliculasFavoritas;
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
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public List<Pelicula> getListaPeliculasFavoritas() {
		return listaPeliculasFavoritas;
	}
	public void setListaPeliculas(List<Pelicula> listaPeliculasFavoritas) {
		this.listaPeliculasFavoritas = listaPeliculasFavoritas;
	}

	
}


