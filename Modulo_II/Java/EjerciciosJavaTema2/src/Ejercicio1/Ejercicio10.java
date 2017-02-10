package Ejercicio1;

public class Ejercicio10 {

	public static void main(String[] args) {
		
		try{
			int N = new Integer(args[0]);
			
			if(N <= 2){
				System.out.println("Introduce un numero mayor de 2");
			}
			else{
				for(int i = (N-1); i != 0; i--){
					if(N % i == 0 && i != 1){
						for(int j = 2; j < N; j++){
							if(i * j == N)
								System.out.print(i + " * " + j + ", ");
						}
					}
				}
			}
		}
		catch(Exception e){
			System.out.println("Error al introducir el dato!");
		}
	}
}