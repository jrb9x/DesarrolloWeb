package Ejercicio1;

public class Ejercicio7 {

	public static void main(String[] args) {
		
		int N = 0, suma = 0;
		
		try{
			N = new Integer(args[0]);
		}
		catch(Exception e){
			System.out.println("Error al introducir los datos.");
		}
		for(int i = (N-1); i != 0; i--){
			if(N % i == 0){
				suma += i;
			}
		}
		if(suma == N)
			System.out.println("El numero " + N + " es perfecto!");
		else
			System.out.println("El numero " + N + " no es perfecto!");
	}
}
