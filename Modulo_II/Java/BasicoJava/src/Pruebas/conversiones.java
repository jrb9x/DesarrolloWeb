package Pruebas;

public class conversiones {

	public static void main (String [] args) {
		
		//int x = new Integer(args[0]);
		//int x = Integer.parseInt(args[0]);
		//double x = new Double(args[0]);
		//double x = Double.parseFloat(args[0]);
		
		int a = 2;
		double b = 3.0;
		float c = (float) (20000*a/b + 5);

		System.out.println("Valor en formato float: " + c);
		System.out.println("Valor en formato double: " + (double) c);
		System.out.println("Valor en formato byte: " + (byte) c);
		System.out.println("Valor en formato short: " + (short) c);
		System.out.println("Valor en formato int: " + (int)c);
		System.out.println("Valor en formato long: " + (long) c);
	}
}