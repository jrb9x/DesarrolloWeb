package Ejercicio1;

public class Ejercicio6 {

	public static void main(String[] args) {
		
		int N = 0, factorial = 1;
		
		try{
			N = new Integer(args[0]);
		}
		catch(Exception e){
			System.out.println("Error al introducir los datos");
		}
		
		for(int i = 1; i <= N; i++){
			factorial *= i;
		}
		System.out.println(N + "! = " + factorial);
		
	}

}
