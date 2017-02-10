package ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuCoche {

	static Concesionario concesionario = new Concesionario();
	
	static Coche coche1 = new Coche("6181 KDL","Audi","A8",59135.5);
	static Coche coche2 = new Coche("7862 JJC","Audi","TT",10589.5);
	static Coche coche3 = new Coche("7642 BBB","Mercedes","Clase SLC",92156.5);
	static Coche coche4 = new Coche("5464 TSC","Audi","R8",26842.5);
	static Coche coche5 = new Coche("4545 YGN","Mercedes","AMG GT",80165.5);
	
	public static void main(String[] args) {
		
		concesionario.addCoche(coche1);
		concesionario.addCoche(coche2);
		concesionario.addCoche(coche3);
		concesionario.addCoche(coche4);
		concesionario.addCoche(coche5);
		
		MenuCoche menucoche = new MenuCoche();
		menucoche.mostrarMenu();
	}
	
	public void mostrarMenu() {
		
		while(true){
			System.out.println("Bienvenido elige una opcion a mostrar;");
			System.out.println("1 - Todos los coches introducidos: ");
			System.out.println("2 - Todos los coches de una marca determinada: ");
			System.out.println("3 - Todos los coches con menos kilometros que: ");
			System.out.println("4 - Coche con mayor numero de kilometros: ");
			System.out.println("5 - Todos los coches ordenados por kilometros(menor a mayor): ");
			System.out.println("0 - salir");
			int opcion = solicitarOpcion(6, "Indica la opcion:");
			switch (opcion) {
			case 1:
				concesionario.mostrarCoches();
				break;
			case 2:
				buscarCochesMarca();
				break;
			case 3:
				buscarCochesKm();
				break;
			case 4:
				concesionario.mostrarCocheMasKm();
				break;
			case 5:
				concesionario.mostrarCochesOrdenados();
				break;
			case 0:
				System.exit(0);
			default:
				break;
			}
		}
	}
	
	@SuppressWarnings("resource")
	public int solicitarOpcion(int max, String mensaje){
		boolean isError = true;
		int numero = 0;
		do{
			try {
				System.out.println(mensaje);
				Scanner entrada = new Scanner(System.in);
				numero = entrada.nextInt();
				
				if(numero >= 0 && numero < max)
					isError = false;
				}
			
			catch (InputMismatchException e){
				System.out.println("Error, no es un numero");
			}
		}while(isError);
		
		return numero;
	 }
	
	private void buscarCochesMarca() {
		String m = solicitarCadena("Marca: ");
		concesionario.buscarCochesPorMarca(m);
	}
	
	private void buscarCochesKm() {
		double km = solicitarDouble("Kilometros: ");
		concesionario.buscarCochesMenosKm(km);
	}

	@SuppressWarnings("resource")
	public String solicitarCadena(String mensaje){
		String resultado = "";
		
		System.out.println(mensaje);
		Scanner entrada = new Scanner(System.in);
		resultado = entrada.nextLine();
		
		return resultado;
	}
	
	@SuppressWarnings("resource")
	public double solicitarDouble(String mensaje){
		double resultado = 0;
		
		System.out.println(mensaje);
		Scanner entrada = new Scanner(System.in);
		resultado = entrada.nextInt();
		
		return resultado;
	}
}
