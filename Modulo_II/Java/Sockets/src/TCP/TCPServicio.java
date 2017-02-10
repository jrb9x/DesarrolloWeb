package TCP;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPServicio extends Thread{

	Socket skCliente;
	int numCliente;
	
	public TCPServicio(Socket socket, int numeroCliente){
		skCliente = socket;
		numCliente = numeroCliente;
	}
	
	public void run(){
		
		try {
			System.out.println("Sirvo al cliente " + numCliente);
			OutputStream aux = skCliente.getOutputStream();
			DataOutputStream flujo = new DataOutputStream(aux);
			flujo.writeUTF("Hola cliente " + numCliente);
			skCliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
