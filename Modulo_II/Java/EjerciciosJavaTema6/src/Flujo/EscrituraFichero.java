package Flujo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscrituraFichero {
	
	public static void main(String args[]) throws IOException{
		try { // escritura de datos
			File fichero = new File("prueba.txt");
			if(fichero.exists()){
				System.out.println(fichero.getAbsolutePath());
			}
			
			PrintWriter salida = new PrintWriter(new FileWriter(fichero));
			salida.println("Este es un ejemplo de escritura y lectura de datos");
			salida.println("en un fichero.");
			salida.close();
			
			// lectura de datos
			BufferedReader entrada =new BufferedReader(new FileReader(fichero)); String s, s2 = new String();
			while((s = entrada.readLine())!= null)
				s2 += s + "\n";
			System.out.println("Texto leido:" + "\n" + s2);
			entrada.close();
		} catch (java.io.IOException e) { e.printStackTrace(); }
	}
}

/*
** Serializacion de Objetos Clase Bombero
*/