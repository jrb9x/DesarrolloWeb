package PlantillaUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClienteUDP {

	DatagramSocket socket;
	
	static final int PUERTO = 6789;
	
	public ClienteUDP(){
		
	}
	
	public void enviar(String mensaje, String destino){
		try {
			socket = new DatagramSocket();
			byte[] m = mensaje.getBytes();
			InetAddress host = InetAddress.getByName(destino);
			DatagramPacket req = new DatagramPacket(m, mensaje.length(), host, PUERTO);
			socket.send(req);
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public byte[] recibir(){
		byte[] n = new byte[1000];
		DatagramPacket rep = new DatagramPacket(n, n.length);
		try {
			socket.receive(rep);
			return rep.getData();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void cerrar(){
		if (socket != null) 
			socket.close();
	}
	
}
