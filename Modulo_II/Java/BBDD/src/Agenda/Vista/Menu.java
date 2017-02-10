package Agenda.Vista;

import java.util.ArrayList;

import Agenda.BEANS.Fecha;
import Agenda.BEANS.Persona;
import Agenda.Negocio.Agenda;

public class Menu {

	Agenda agenda = new Agenda();
	Teclado teclado = new Teclado();
	
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
			System.out.println("4 - Modificar Persona(por DNI): ");
			System.out.println("5 - Mostrar Agenda: ");
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
				modificarPersona();
				break;
			case 5:
				mostrarAgenda();
				break;
			case 0:
				System.exit(0);
			default:
				break;
			}
		}
	}
	
	public int solicitarOpcion(int max, String mensaje){
		boolean isError = true;
		int numero = 0;
		do{
			System.out.println(mensaje);
			numero = teclado.leerInt();
			if(numero >= 0 && numero < max)
				isError = false;
		}while(isError);
		
		return numero;
	 }

	private void crearPersona() {
		System.out.println("Introduzca los datos del contacto");
		String nombre = solicitarCadena("Nombre: ");
		String apellidos = solicitarCadena("Apellidos: ");
		String dni = solicitarCadena("DNI: ");
		String telefono = solicitarCadena("Telefono: ");
		Fecha fecha = solicitarFecha("Fecha de Nacimiento: ");
	
		Persona persona = new Persona(nombre, apellidos, dni, telefono, fecha);
		System.out.println(agenda.aniadirPersona(persona));
	}
	
	private void mostrarAgenda(){
		ArrayList<Persona> lista = agenda.recuperarAgenda();
		for (Persona persona : lista) {
			System.out.println("***************************************************");
			System.out.println(persona.toString());
			System.out.println("***************************************************");
		}
	}
	
	private void borrarPersona() {
		String dni = solicitarCadena("DNI: ");
		System.out.println(agenda.borrarPersonaPorDni(dni));
	}
	
	private void buscarPersona() {
		String dni = solicitarCadena("DNI: ");
		System.out.println("***************************************************");
		System.out.println(agenda.buscarPersonaPorDni(dni));
		System.out.println("***************************************************");
	}
	
	private void modificarPersona() {
		String dni = solicitarCadena("DNI: ");
		
		System.out.println("Introduzca los nuevos datos del contacto");
		String nombre = solicitarCadena("Nombre: ");
		String apellidos = solicitarCadena("Apellidos: ");
		String telefono = solicitarCadena("Telefono: ");
		Fecha fecha = solicitarFecha("Fecha de Nacimiento: ");
	
		Persona persona = new Persona(nombre, apellidos, dni, telefono, fecha);
		System.out.println(agenda.modificarPersonaPorDni(persona));
	}
	
	public String solicitarCadena(String mensaje){
		boolean isError = true;
		String resultado = "";
		do{
			System.out.println(mensaje);
			resultado = teclado.leerString();
			if(resultado.length() > 0)
				isError = false;
		}while(isError);
		
		return resultado;
	}
	
	public int solicitarInt(String mensaje){
		int resultado = 0;
		
		System.out.println(mensaje);
		resultado = teclado.leerInt();
		return resultado;
	}
	
	public Fecha solicitarFecha(String mensaje){

		System.out.println(mensaje);
		String Dia = solicitarCadena("Introduce Dia: ");
		String Mes = solicitarCadena("Introduce Mes: ");
		String Anio = solicitarCadena("Introduce Año: ");
		
		Fecha fecha = new Fecha(Dia,Mes,Anio);
		
		return fecha;
	}
	 
}
