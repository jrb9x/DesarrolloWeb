package Ejercicios;

public class Ejercicio4 {

	public static void main(String[] args){
		
		Autor autor = new Autor("Paul", "Auster");
		Libro libro = new Libro("La trilog�a de Nueva York", autor);
		System.out.println(libro.getTitulo()+ " de " +libro.getAutor().toString());
	}
}
		
class Libro{
	private String titulo;
	private Autor autor;
		
	public Libro(String titulo, Autor autor){
		this.titulo = titulo;
		this.autor = autor;
	}
	
	public Autor getAutor(){
		return autor;
	}
		
	public String getTitulo(){
		return titulo;
	}
}

class Autor{
	private String nombre;
	private String apellido;
	
	public Autor(String nombre, String apellido){
		this.nombre=nombre;
		this.apellido=apellido;
	}
	
	public String toString(){
		return nombre+ " " +apellido;
	}
}

//