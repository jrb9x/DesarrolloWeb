package PlantillaUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServidorUDP extends Thread{

	DatagramSocket socket;
	
	public ServidorUDP(){
		try {
			socket = new DatagramSocket(ClienteUDP.PUERTO);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		servir();
	}
	
	public void servir(){
		while (true) {
			DatagramPacket request = recibirRequest();
			responderRequest(request);
		}
	}
	
	public DatagramPacket recibirRequest(){
		DatagramPacket req = null;
		try {
			byte[] n = new byte[1000];
			req = new DatagramPacket(n, n.length);
			socket.receive(req);
				
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return req;
		
	}
	
	public void responderRequest(DatagramPacket request){
		try {
			DatagramPacket req = new
					DatagramPacket(
							request.getData(),
							request.getLength(), 
							request.getAddress(),
							request.getPort());
			socket.send(req);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cerrar(){
		if (socket != null) 
			socket.close();
	}
	
}
