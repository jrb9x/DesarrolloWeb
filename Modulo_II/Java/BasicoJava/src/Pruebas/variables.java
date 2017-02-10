package Pruebas;

public class variables {
	
	int z = 3;
	
	public static void main(String[] args) {
		
		final double PI = 3.1415926536;//No se pueden modificar las constantes
		int a=5, b=0, c;
		//double d; d=(double)45;
		
		b = a * 3; // Se cambia el valor de b a 15
		c = a; // Se guarda en c el valor de a que es 5
		a = a + 6; // Se suma 6 al valor que tenía a.
		b = a - c; // b guarda 11 - 5 que es 6
		
		long resultado = 2147483647L * 2;//*sufijo L para no multiplicar por dos int
		
		System.out.println("La constante: " + PI);
		System.out.println(resultado);
		System.out.println("La variable a contiene: " + a);
		System.out.println("La variable b contiene: " + b);
		System.out.println("La variable c contiene: " + c);
	}
	
	public void otroMetodo(){
		int x = 34;
		System.out.println("La variable c contiene : " + z);
		System.out.println("La variable c contiene : " + x);
	}
	
	public void otroMetodo2(){
		
		System.out.println("La variable c contiene : " + z);
		//System.out.println("La variable c contiene : " + x); La x esta definida en otro metodo
	}
}

