package Ejercicio1;

public class Ejercicio1 {

	public static void main(String[] args) {

		int a�o = 0;
		
		try{
			a�o = new Integer(args[0]);
		}
		catch(Exception e){
			System.out.println("Introduce el a�o correctamente");
			System.exit(0);
		}
		
		if ((a�o % 4 == 0) && ((a�o % 100 != 0) || (a�o % 400 == 0)))
			System.out.println("El a�o " + a�o + " es bisiesto");
		else
			System.out.println("El a�o " + a�o + " no es bisiesto");
		

	}

}
