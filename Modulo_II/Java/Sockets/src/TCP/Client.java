package TCP;

import java.io.*;
import java.net.*;

class Client {
	static final String HOST = "localhost";
	static final int Puerto = 6000;

	public Client() {
		try {
			Socket skCliente = new Socket(HOST, Puerto);
			Thread.sleep(5000);
			InputStream aux = skCliente.getInputStream();
			DataInputStream flujo = new DataInputStream(aux);
			System.out.println(flujo.readUTF());
			skCliente.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String args[]) {
		new Client();
	}
}