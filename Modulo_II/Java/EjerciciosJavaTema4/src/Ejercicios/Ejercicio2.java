package Ejercicios;

public class Ejercicio2 {

	public static void main(String[] args) {

		int pedido = new Integer(args[0]);
		double N[];
		N = new double [10];
		
		for(int i=0;i<N.length;i++){
			N[i] = Math.floor(Math.random()*100);
		}
			
		System.out.println("Valor en la posicion " + pedido +": "+ N[pedido]);
		

	}

}
