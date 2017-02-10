package Interfaces;

public class Racional implements Imprimible{

	private int numerador, denominador;

	public Racional() {
		this.setNumerador(0);
		this.setDenominador(1);
	}

	public Racional(int numerador, int denominador) {
		this.setNumerador(numerador);
		this.setDenominador( denominador);
	}

	public int getNumerador() {
		return numerador;
	}

	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public int getDenominador() {
		return denominador;
	}

	public void setDenominador(int denominador) {
		this.denominador = denominador;
	}

	public int maximoComunDivisor(Integer num1, Integer num2) {
		int mcd = 0;
		int a = Math.max(num1, num2);
		int b = Math.min(num1, num2);
		do {
			mcd = b;
			b = a % b;
			a = mcd;
		} while (b != 0);
		return mcd;
	}

	public int minimoComunMultiplo(Integer num1, Integer num2) {
		int mcm = 0;
		int a = Math.max(num1, num2);
		int b = Math.min(num1, num2);
		mcm = (a / maximoComunDivisor(a, b)) * b;
		return mcm;
	}

	public Racional sumar(Racional r) {
		Racional resultado = new Racional();
		int mcm = minimoComunMultiplo(this.getDenominador(), r.getDenominador());
		resultado.setNumerador((this.getNumerador() * mcm / this.getDenominador()) + (r.getNumerador() * mcm / r.getDenominador()));
		resultado.setDenominador(mcm);
		return resultado;
	}

	public Racional restar(Racional r) {
		Racional resultado = new Racional();
		int mcm = minimoComunMultiplo(this.getDenominador(), r.getDenominador());
		resultado.setNumerador((this.getNumerador() * mcm / this.getDenominador()) - (r.getNumerador() * mcm / r.getDenominador()));
		resultado.setDenominador(mcm);
		return resultado;
	}

	public Racional multiplicar(Racional r) {
		Racional resultado = new Racional();
		resultado.setNumerador(this.getNumerador() * r.getNumerador());
		resultado.setDenominador(this.getDenominador() * this.getDenominador());
		return resultado;
	}

	public Racional dividir(Racional r) {
		Racional resultado = new Racional();
		resultado.setNumerador(this.getNumerador() * r.getDenominador());
		resultado.setDenominador( this.getDenominador() * this.getNumerador());
		return resultado;
	}

	public boolean comparar(Racional r) {
		double num1 = (double) this.getNumerador() / this.getDenominador();
		double num2 = (double) r.getNumerador() / r.getDenominador();
		return num1 == num2;
	}

	@Override
	public void imprimir() {
		System.out.println(this.getNumerador() + "/" + this.getDenominador());
		
	}
}
