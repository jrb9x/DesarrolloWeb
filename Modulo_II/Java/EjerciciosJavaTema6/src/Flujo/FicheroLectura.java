package Flujo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FicheroLectura {

	private BufferedReader entrada;
	
	//public FicheroLectura(){}

	public boolean abrir(String nombreFichero){
		boolean error = true;
		try {
			entrada = new BufferedReader(new FileReader(nombreFichero));
			error = false;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return error;
	}
	
	public String leerLinea(){
		try {
			return entrada.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public String leerCadena() {
		String cadena = "";
		int c = (int) ' ';
		try {
			while((c = (char) entrada.read()) != ' ' && c != -1){
				cadena += (char) c;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cadena;
	}
	
	public String leerCadena(char separador) {
		String cadena = "";
		int c = (int) ' ';
		try {
			while((c = (char) entrada.read()) != separador && c != -1){
				cadena += (char) c;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cadena;
	}

	public void cerrar(){
		try{
			entrada.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}