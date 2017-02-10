package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient {
	
	public static void main(String args[]) {
		DatagramSocket socket = null;
		try {
			//Enviar
			socket = new DatagramSocket();
			byte[] m = args[0].getBytes();
			InetAddress host = InetAddress.getByName(args[1]);
			int port = 6789;
			DatagramPacket req = new DatagramPacket(m, args[0].length(), host, port);
			socket.send(req);
			System.out.println(InetAddress.getLocalHost().getHostAddress());
			
			//Recibir
			byte[] n = new byte[1000];
			DatagramPacket rep = new DatagramPacket(n, n.length);
			socket.receive(rep);
			System.out.println("Received "+ new String(rep.getData()));
		
		} catch (SocketException e) {
			System.out.println("Socket: "+e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: "+e.getMessage());
		} finally { if (socket != null) socket.close(); }
	}
}