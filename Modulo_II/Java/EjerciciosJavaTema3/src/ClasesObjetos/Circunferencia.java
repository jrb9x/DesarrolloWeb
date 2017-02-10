package ClasesObjetos;

public class Circunferencia {

	public double x, y, radio;
	public static int valor = 13;
	
	static{
		System.out.println("Me ejecuto solo");
		valor = 25;
	}
	
	public Circunferencia(){
		this.x = 0.0;
		this.y = 3.0;
		this.radio = 5;
	}
	
	public Circunferencia(double x){ //Distintos constructores igual nombre(Firma)
		
		this.x = x;
		this.y = 3.0;
		this.radio = 5;
	}
	
	public Circunferencia(double x, double y, double radio) {
		this.x = x;
		this.y = y;
		this.radio = radio;
	}

	public static void prueba(){
		
		System.out.println("Esta es la prueba de que no necesitas nada en memoria para ejecutar");
	}
	
	public void ponRadio(double r){
	
		radio=r;
	}
	
	public double longitud(){
	
		return 2*Math.PI*radio;
	}
}
