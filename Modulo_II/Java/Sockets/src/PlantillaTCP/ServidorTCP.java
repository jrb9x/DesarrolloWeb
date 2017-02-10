package PlantillaTCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP extends Thread{
	public static final int PUERTO=2323;
	ServerSocket serverSocket;
	
	public ServidorTCP() throws IOException{
		serverSocket = new ServerSocket(PUERTO);
	}
	
	public void run(){
		servir();
	}
	public void servir(){
		int i=0;
		while(true){
			try {
				Socket socket = serverSocket.accept();
				ServicioServidorTCP servicio = new ServicioServidorTCP(socket, "servicio"+i);
				i++;
				servicio.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
