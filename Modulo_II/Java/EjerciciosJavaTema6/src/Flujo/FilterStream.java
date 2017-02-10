package Flujo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilterStream {

	public static void main(String[] args) throws IOException{
		FileOutputStream ficheroSalida = new FileOutputStream("precios.cat");
		DataOutputStream salida = new DataOutputStream(ficheroSalida);
		salida.writeDouble(685.25);
		salida.close();
		
		FileInputStream ficheroEntrada = new FileInputStream("precios.cat");
		DataInputStream entrada = new DataInputStream(ficheroEntrada);
		
		double precio= entrada .readDouble();
		System.out.println(precio);
		entrada.close();
	}
}
