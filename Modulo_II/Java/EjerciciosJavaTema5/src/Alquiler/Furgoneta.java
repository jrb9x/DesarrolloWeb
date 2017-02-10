package Alquiler;

public class Furgoneta extends Vehiculo{
	
	private double capacidadCarga;
	
	public Furgoneta() {
		super();
	}

	public Furgoneta(String matricula, double kilometraje, boolean alquilado, double capacidadCarga) {
		super(matricula, kilometraje, alquilado);
		this.capacidadCarga = capacidadCarga;
	}

	public double getCapacidadCarga() {
		return capacidadCarga;
	}

	public void setCapacidadCarga(double capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}

	@Override
	public String toString() {
		return "Furgoneta [matricula: " + getMatricula() 
							+ "\n kilometraje: " + getKilometraje() 
							+ "\n Alquilado: " + getAlquilado() 
							+ "\n capacidadCarga=" + capacidadCarga + "]";
	}
	
	public String alquilarVehiculo(){
		
		if(getAlquilado() == true)
			return "Furgoneta no disponible";
		else{
			setAlquilado(true);
			return "Furgoneta alquilada correctamente";
		}
		
	}
	
	public String devolverVehiculo(){
		return null;
		
	}
	
}
