package Alquiler;

public abstract class Vehiculo {

	private String matricula;
	private double kilometraje;
	private boolean alquilado;
	
	public Vehiculo(){
		
	}

	public Vehiculo(String matricula, double kilometraje, boolean alquilado) {
		super();
		this.matricula = matricula;
		this.kilometraje = kilometraje;
		this.alquilado = alquilado;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(double kilometraje) {
		this.kilometraje = kilometraje;
	}

	public boolean getAlquilado() {
		return alquilado;
	}

	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula: " + matricula 
				+ "\n kilometraje: " + kilometraje 
				+ "\n Alquilado: " + alquilado + "]";
	}
	
	public abstract String alquilarVehiculo();
	
	public abstract String devolverVehiculo();
}
	
