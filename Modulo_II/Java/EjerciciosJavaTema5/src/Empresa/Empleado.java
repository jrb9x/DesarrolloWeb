package Empresa;

public class Empleado {

	private String nombre;
	private String nif;
	private int edad;
	private boolean casado;
	private double salario;
	
	public Empleado(){
		
	}

	public Empleado(String nombre, String nif, int edad, boolean casado, double salario) {
		this.nombre = nombre;
		this.nif = nif;
		this.edad = edad;
		this.casado = casado;
		this.salario = salario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isCasado() {
		return casado;
	}

	public void setCasado(boolean casado) {
		this.casado = casado;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + "\n nif=" + nif + "\n edad=" + edad + "\n casado=" + casado + "\n salario="
				+ salario + "\n clasificacion=" + mostrarClasificacion(edad) + "]";
	}
	
	public String mostrarClasificacion(int edad){
		if(edad <= 21)
			return "Principiante";
		else if(edad > 35)
			return "Senior";
		else
			return "Intermedio";
	}
	
	public void aumentarSalario(double porcentaje){
        this.salario = this.salario + ((this.salario * porcentaje)/100);
    }
}
