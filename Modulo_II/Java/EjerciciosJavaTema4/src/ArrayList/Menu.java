package ArrayList;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	Agenda agenda = new Agenda();
	
	 public static void main(String[] args) {
		 Menu menu = new Menu();
		 menu.mostrarMenu();
	}
			
	public void mostrarMenu() {
	
		while(true){
			System.out.println("Bienvenido elige una de las opciones;");
			System.out.println("1 - Añadir Persona: ");
			System.out.println("2 - Borrar Persona(por DNI): ");
			System.out.println("3 - Buscar Persona(por DNI): ");
			System.out.println("4 - Mostrar Agenda: ");
			System.out.println("5 - Mostrar Personas(por mes de cumpleaños): ");
			System.out.println("0 - salir");
			int opcion = solicitarOpcion(6, "Indica la opcion:");
			switch (opcion) {
			case 1:
				crearPersona();
				break;
			case 2:
				borrarPersona();
				break;
			case 3:
				buscarPersona();
				break;
			case 4:
				mostrarAgenda();
				break;
			case 5:
				mostrarPersona();
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

	private void crearPersona() {
		System.out.println("Introduzca los datos del empleado");
		String nombre = solicitarCadena("Nombre: ");
		String apellidos = solicitarCadena("Apellidos: ");
		String dni = solicitarCadena("DNI: ");
		int telefono = solicitarInt("Telefono: ");
		Fecha fecha = solicitarFecha("Fecha de Nacimiento: ");
	
		Persona persona = new Persona(nombre, apellidos, dni, telefono, fecha);
		agenda.aniadirPersona(persona);
	}
	
	private void mostrarAgenda(){
		ArrayList<Persona> lista = agenda.recuperarAgenda();
		for (Persona persona : lista) {
			System.out.println(persona.toString());
		}
	}
	
	private void borrarPersona() {
		String dni = solicitarCadena("DNI: ");
		agenda.borrarPersonaPorDni(dni);
		System.out.println("Persona con DNI " + dni + " eliminada!");
	}
	
	private void buscarPersona() {
		String dni = solicitarCadena("DNI: ");
		Persona persona = agenda.buscarPersonaPorDni(dni);
		System.out.println(persona.toString());
	}
	
	private void mostrarPersona(){
		int mes = solicitarInt("Introduce Numero del Mes: ");
		ArrayList<Persona> lista = agenda.listarPorMesCumple(mes);
		for (Persona persona : lista) {
			System.out.println(persona.toString());
		}
		
	}
	
	@SuppressWarnings("resource")
	public String solicitarCadena(String mensaje){
		boolean isError = true;
		String resultado = "";
		do{
			System.out.println(mensaje);
			Scanner entrada = new Scanner(System.in);
			resultado = entrada.nextLine();
			if(resultado.length() > 3)
				isError = false;
		}while(isError);
		
		return resultado;
	}
	
	@SuppressWarnings("resource")
	public int solicitarInt(String mensaje){
		int resultado = 0;
		
		System.out.println(mensaje);
		Scanner entrada = new Scanner(System.in);
		resultado = entrada.nextInt();
		
		return resultado;
	}
	
	public Fecha solicitarFecha(String mensaje){

		System.out.println(mensaje);
		int Dia = solicitarInt("Introduce Dia: ");
		int Mes = solicitarInt("Introduce Mes: ");
		int Anio = solicitarInt("Introduce Año: ");
		
		Fecha fecha = new Fecha(Dia,Mes,Anio);
		
		return fecha;
	}
	 
}
