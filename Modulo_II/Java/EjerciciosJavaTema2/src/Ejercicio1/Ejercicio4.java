package Ejercicio1;

public class Ejercicio4 {


	public static void main(String[] args) {
		
		try{
			int N = new Integer(args[0]);
			
			if(N < 1){
				System.out.println("Introduce un numero entero");
			}
			else{
				int numero1 = 1;
				int numero2 = 1;
				int aux;
				for(int i = 1; i <= N; i++){
					aux = numero1;
					numero1 = numero2;
					numero2 = aux + numero1;
					System.out.println("...");
					
				}
			}
		}
		catch(Exception e){
			System.out.println("Error al introducir el dato");
		}
		
	}
	
}
