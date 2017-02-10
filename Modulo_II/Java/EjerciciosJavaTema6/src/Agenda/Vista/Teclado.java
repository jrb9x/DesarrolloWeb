package Agenda.Vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Teclado {

	private BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	
	public String leerString(){
		String cadena = "";
		try{
			cadena = new String(entrada.readLine());
		}catch (IOException e) {
			System.out.println("Error de E/S");
		}
		return cadena;
	}
	
	public int leerInt() {
		
		int entero = 0;
		boolean error = false;
		
		do {
			try {
				error = false;
				entero = Integer.valueOf(entrada.readLine()).intValue();
			}catch (NumberFormatException e1) {
				error = true;
				System.out.println("Error en el formato del numero, intentelo de nuevo.");
			}catch (IOException e) {
				System.out.println("Error de E/S");
			}
		} while (error);
		return entero;
	}
	
	public double leerDouble(){
		double numero = 0.0;
		boolean error = false;
		do{
			try {
				error = false;
				numero = Double.valueOf(entrada.readLine());
			}catch (NumberFormatException e1) {
				error = true;
				System.out.println("Error en el formato del numero, intentelo de nuevo.");
			}catch (IOException e) {
				System.out.println("Error de E/S");
			}
		} while (error);
		return numero;
	}
}
