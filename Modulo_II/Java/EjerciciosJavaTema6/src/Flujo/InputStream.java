package Flujo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStream {

	public static void main(String[] args) throws IOException {

		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader teclado = new BufferedReader(in);
		String linea = teclado.readLine();
		System.out.println(linea);

	}

}
