package ejercicio4;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		int pies = 0;//inicializar fuera del try
		double pulgadas = 12, yardas = 0.333333, cm = 2.54, metros;
		
		//Excepciones
		try{
			pies = new Integer(args[0]);
		}
		catch(Exception e){
			System.out.println("Introduce un numero!");
			e.printStackTrace();
		}
		
		pulgadas *= pies;
		yardas *= pies;
		cm *= pulgadas;
		metros = cm / 100;
		
		System.out.println(pies + " pies en pulgadas: " + pulgadas);
		System.out.println(pies + " pies en yardas: " + yardas);
		System.out.println(pies + " pies en cm: " + cm);
		System.out.println(pies + " pies en metros: " + metros);
		
	}

}
