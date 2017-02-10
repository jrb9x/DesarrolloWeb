package ejercicio2;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		double peso, gravedad = 1.62;
		int masa = new Integer(args[0]);
		
		peso = masa * gravedad;
		
		System.out.println(peso + " N");
	}
}
