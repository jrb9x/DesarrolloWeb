package Alquiler;

public class Coche extends Vehiculo{
	
	private boolean extras;
	
	public Coche() {
		super();
	}
	
	public Coche(String matricula, double kilometraje, boolean alquilado, boolean extras) {
		super(matricula, kilometraje, alquilado);
		this.extras = extras;
	}
	
	public boolean isExtras() {
		return extras;
	}
	
	public void setExtras(boolean extras) {
		this.extras = extras;
	}
	
	@Override
	public String toString() {
		return "Coche [matricula: " + getMatricula() 
							+ "\n kilometraje: " + getKilometraje() 
							+ "\n Alquilado: " + getAlquilado() 
							+ "\n extras: " + extras + "]";
	}
	
	public String alquilarVehiculo(){
	
		if(getAlquilado() == true)
			return "Coche no disponible";
		else{
			setAlquilado(true);
			return "Coche alquilado correctamente";
		}
		
	}
	
	public String devolverVehiculo(){
		return null;
		
	}
}
