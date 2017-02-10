package Flujo;

import java.io.IOException;

public class Estandar {

	public static void main(String[] args) throws IOException {
		int c;
		int contador = 0;
		
		while((c = System.in.read()) != '\n'){
			contador++;
			System.out.print((char) c);
		}
		System.out.println(); // Se escribe el fin de línea
		System.err.println( "Contados "+ contador +" bytes en total." );

	}

}
