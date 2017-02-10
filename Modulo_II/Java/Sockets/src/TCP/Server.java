package TCP;

import java.net.*;

class Server {
	static final int PUERTO = 6000;

	public Server() {
		try {
			ServerSocket skServidor = new ServerSocket(PUERTO);
			System.out.println("Escucho el puerto " + PUERTO);
			for (int numCli = 0; numCli > -1; numCli++) {
				Socket skCliente = skServidor.accept(); // Crea objeto
				
				TCPServicio servicio = new TCPServicio(skCliente, numCli);
				servicio.start();
			}
			skServidor.close();
			System.out.println("Clientes Atendidos");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] arg) {
		new Server();
	}
}