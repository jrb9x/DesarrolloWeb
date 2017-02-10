package ejemplo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Estudiante {

	private String nombre;
	private int edad;
	private List<Estudiante> amigo = new ArrayList<>();
	//@Autowired
	private Estudiante comp;

	
	public Estudiante() {
		super();
	}
	

	public Estudiante(String nombre, int edad, List<Estudiante> amigo, Estudiante comp) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.amigo = amigo;
		this.comp = comp;
	}

	public void inicio(){
		System.out.println("Me han creado, mi edad: " + edad);
	}
	
	public void destruir(){
		System.out.println("Me van a destruir, mi edad: " + edad);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	

	public List<Estudiante> getAmigo() {
		return amigo;
	}

	public void setAmigo(List<Estudiante> amigo) {
		this.amigo = amigo;
	}
	

	public Estudiante getComp() {
		return comp;
	}


	public void setComp(Estudiante comp) {
		this.comp = comp;
	}


	/*@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", edad=" + edad + ", amigo=" + amigo.size() + ", comp=" + comp + "]";
	}
	*/
}
