package Herencia;

@SuppressWarnings("serial")
public class Bombero extends Persona {

	private String municipio;
	private int aniosExperiencia;
	
	public Bombero(){
		super();
	}
	
	public Bombero(String nombre, String apellidos, String dni, String municipio, int aniosExperiencia) {
		super(nombre, apellidos, dni);
		this.municipio = municipio;
		this.aniosExperiencia = aniosExperiencia;
	}

	@Override
	public String toString() {
		return "Bombero [nombre=" + getNombre() +", municipio=" + municipio + ", aniosExperiencia=" + aniosExperiencia + "]";
	}//Al ser privado atributos persona, utilizar get

	public int anioExperiencia(){
		return aniosExperiencia;
	}

	@Override
	public int aniosExperiencia() {
		
		return 0;
	}
}
