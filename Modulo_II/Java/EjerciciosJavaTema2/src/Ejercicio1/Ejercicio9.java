package Ejercicio1;

public class Ejercicio9 {

	public static void main(String[] args) {
		
		int N = 0;
		String string1 = " ";
		
		try{
			N = new Integer(args[0]);
		}
		catch(Exception e){
			System.out.println("Error al introducir los datos!");
		}
		
		for(int i = 0; i != N; i++){
			string1 += "* ";
			System.out.println(string1);
		}

	}
}
