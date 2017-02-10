package beans;

public class BusquedaOferta {

	private double precioMax;
	private int numeroNoches;
	
	public BusquedaOferta() {
		super();
	}
	
	public BusquedaOferta(double precioMax, int numeroNoches) {
		super();
		this.precioMax = precioMax;
		this.numeroNoches = numeroNoches;
	}
	
	public double getPrecioMax() {
		return precioMax;
	}
	
	public void setPrecioMax(double precioMax) {
		this.precioMax = precioMax;
	}
	
	public int getNumeroNoches() {
		return numeroNoches;
	}
	
	public void setNumeroNoches(int numeroNoches) {
		this.numeroNoches = numeroNoches;
	}
	
}
