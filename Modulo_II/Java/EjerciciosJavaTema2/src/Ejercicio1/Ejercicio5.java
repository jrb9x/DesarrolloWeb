package Ejercicio1;

public class Ejercicio5 {

	public static void main(String[] args) {
		
		int N = 0, M = 0, R;
		
		try{
		N = new Integer(args[0]);
		M = new Integer(args[1]);
		}
		catch(Exception e){
			System.out.println("Error al introducir los datos.");
		}
		
		do{
			R = N % M;
			if(R == 0){
				System.out.println("El MCD es: " + M);
			}
			else{
				N = M;
				M = R;
			}
		}while(R != 0);
	}

}
