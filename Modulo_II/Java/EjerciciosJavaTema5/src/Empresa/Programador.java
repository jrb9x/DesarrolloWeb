package Empresa;

public class Programador extends Empleado {
	
	protected int lineasDeCodigoPorHora;
	protected String lenguajeDominante;
	
	public Programador(){
		super();
	}
	
	public Programador(String nombre, String nif, int edad, boolean casado, double salario, int lineasDeCodigoPorHora,
			String lenguajeDominante) {
		super(nombre, nif, edad, casado, salario);
		this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
		this.lenguajeDominante = lenguajeDominante;
	}

	@Override
	public String toString() {
		return  "Programador [nombre= " + getNombre() + "\n nif= " + getNif() + "\n edad= " + getEdad() + "\n casado= " + isCasado() + "\n salario= "
				+ getSalario() + "\n clasificacion= " + mostrarClasificacion(getEdad()) + "\n lineasDeCodigoPorHora=" + lineasDeCodigoPorHora + ", lenguajeDominante="
				+ lenguajeDominante + "]";
	}

	public int getLineasDeCodigoPorHora() {
		return lineasDeCodigoPorHora;
	}

	public void setLineasDeCodigoPorHora(int lineasDeCodigoPorHora) {
		this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
	}

	public String getLenguajeDominante() {
		return lenguajeDominante;
	}

	public void setLenguajeDominante(String lenguajeDominante) {
		this.lenguajeDominante = lenguajeDominante;
	}
	
	
}
