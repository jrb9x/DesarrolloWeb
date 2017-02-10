package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {

	public static void main(String args[]) {
		DatagramSocket socket = null;
		try {
			
			socket = new DatagramSocket(6789);
			byte[] n = new byte[1000];
			while (true) {
				DatagramPacket req = new
						DatagramPacket(n, n.length);
				System.out.println("Soy Server y espero Requests");
				socket.receive(req);
				System.out.println("Soy Server y he recibido el Requests: " + new String(req.getData()));
				DatagramPacket rep = new
						DatagramPacket(
								req.getData(),
								req.getLength(), 
								req.getAddress(),
								req.getPort());
				System.out.println("Soy Server y contesto lo mismo");
				socket.send(rep);
			}
		} catch (SocketException e) {
			System.out.println("Socket: "+e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: "+e.getMessage());
		} finally { if (socket != null) socket.close(); }
	}
}
