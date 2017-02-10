package ArrayList;

public class Isosceles {
	
	private double base;
	private double altura;
	
	public Isosceles(){
		
	}

	public Isosceles(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double calcularPerimetro(){
		return (2 * base) + altura;
	}
	
	public double calcularArea(){
		//return (base * Math.sqrt(Math.pow(altura, 2) - (Math.pow(base, 2) / 4))) / 2;
		return (base * altura) / 2;
	}

	@Override
	public String toString() {
		return "Isosceles [base=" + base + ", altura=" + altura + "]";
	}
	

}
