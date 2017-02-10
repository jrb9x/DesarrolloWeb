package Ejercicio1;

public class Ejercicio1 {

	public static void main(String[] args) {

		int año = 0;
		
		try{
			año = new Integer(args[0]);
		}
		catch(Exception e){
			System.out.println("Introduce el año correctamente");
			System.exit(0);
		}
		
		if ((año % 4 == 0) && ((año % 100 != 0) || (año % 400 == 0)))
			System.out.println("El año " + año + " es bisiesto");
		else
			System.out.println("El año " + año + " no es bisiesto");
		

	}

}
