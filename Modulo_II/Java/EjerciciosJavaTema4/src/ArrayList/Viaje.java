package ArrayList;

public class Viaje {
	public String origen;
	public String destino;
	public double distancia;
	
	public Viaje(){
		
	}
	
	public Viaje(String origen, String destino, double distancia) {
		this.origen = origen;
		this.destino = destino;
		this.distancia = distancia;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public Viaje uneViaje(Viaje viaje2){
		Viaje unionViaje = new Viaje();
		
		unionViaje.origen = this.getOrigen();
		unionViaje.destino = viaje2.destino;
		if (this.getOrigen() == viaje2.destino)
			unionViaje.distancia = -1;
		else
			unionViaje.distancia = this.getDistancia() + viaje2.distancia;
		
		return unionViaje;
	}
	
}
