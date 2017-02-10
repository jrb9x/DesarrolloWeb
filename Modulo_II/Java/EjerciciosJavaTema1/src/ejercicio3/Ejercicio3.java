package ejercicio3;

public class Ejercicio3 {

	public static void main(String[] args) {

		int galones = new Integer(args[0]);
		double litros, galon = 3.7854;
		
		litros = galones * galon;
		System.out.println(litros + " Litros");
	}
}
