package beans;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Pelicula {
	@Id
	@GeneratedValue
	private Integer id;
	private String titulo;
	private LocalDate fechaEstreno;
	private int duracion;
	private String genero;
	private String pais;
	private String sinopsis;
	private String director;
	@ManyToMany
	private List<Celebrity> listaCelebritys;
	private String rutaFoto;
	
	public Pelicula(){
		
	}
	
	public Pelicula(String titulo, LocalDate fechaEstreno, int duracion, String genero, String pais, String sinopsis,
			String director, List<Celebrity> listaCelebritys, String rutaFoto) {
		this.titulo = titulo;
		this.fechaEstreno = fechaEstreno;
		this.duracion = duracion;
		this.genero = genero;
		this.pais = pais;
		this.sinopsis = sinopsis;
		this.director = director;
		this.listaCelebritys = listaCelebritys;
		this.rutaFoto = rutaFoto;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(LocalDate fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public List<Celebrity> getListaCelebritys() {
		return listaCelebritys;
	}

	public void setListaCelebritys(List<Celebrity> listaCelebritys) {
		this.listaCelebritys = listaCelebritys;
	}
	
	public String getRutaFoto(){
		return rutaFoto;
	}
	
	public void setRutaFoto(String rutaFoto){
		this.rutaFoto = rutaFoto;
	}
	
}
