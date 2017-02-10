package Alquiler;

public class Moto extends Vehiculo{
	
	private boolean casco;
	
	public Moto() {
		super();
	}
	
	public Moto(String matricula, double kilometraje, boolean alquilado, boolean casco) {
		super(matricula, kilometraje, alquilado);
		this.casco = casco;
	}
	
	public boolean isCasco() {
		return casco;
	}
	
	public void setCasco(boolean casco) {
		this.casco = casco;
	}
	
	
	@Override
	public String toString() {
		return "Moto [matricula: " + getMatricula() 
							+ "\n kilometraje: " + getKilometraje() 
							+ "\n Alquilado: " + getAlquilado() 
							+ "\n casco: " + casco + "]";
	}
	
	public String alquilarVehiculo(){
		if(getAlquilado() == true)
			return "Moto no disponible";
		else{
			setAlquilado(true);
			return "Moto alquilada correctamente";
		}
	}
	
	public String devolverVehiculo(){
		return null;
		
	}

}
