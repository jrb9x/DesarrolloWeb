package Flujo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FicheroEscritura {
	
	private PrintWriter escritor;
	
	public FicheroEscritura(String nombreFichero, boolean append){
		abrir(nombreFichero, append);
	}
	
	public FicheroEscritura(String nombreFichero){
		abrir(nombreFichero, false);
	}
	
	public boolean abrir(String nombreFichero, boolean append){
		try {
			escritor = new PrintWriter(new FileWriter(nombreFichero, true));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void escribirLinea(String linea){
		escritor.println(linea);

	}

	public void cerrar(){
		escritor.close();
		
	}
}