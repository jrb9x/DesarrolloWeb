package ArrayList;

public class Coche {

	private String matricula;
	private String marca;
	private String modelo;
	private double kilometros;
	
	public Coche(){
		
	}

	public Coche(String matricula, String marca, String modelo, double kilometros) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.kilometros = kilometros;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getKilometros() {
		return kilometros;
	}

	public void setKilometros(double kilometros) {
		this.kilometros = kilometros;
	}

	@Override
	public String toString() {
		return "Coche [ matricula= " + matricula + ", marca= " + marca + ", modelo= " + modelo + ", kilometros= "
				+ kilometros + " ]";
	}
	
}
