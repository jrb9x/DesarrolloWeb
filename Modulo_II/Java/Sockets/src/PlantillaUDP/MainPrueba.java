package PlantillaUDP;

public class MainPrueba {

	public static void main(String[] args) {
		ClienteUDP cliente = new ClienteUDP();
		ServidorUDP servidor = new ServidorUDP();
		
		servidor.start();
		cliente.enviar("Esto es una primera prueba de udp", "127.0.0.1");
		System.out.println("Recibido: " + new String(cliente.recibir()));
		cliente.enviar("Esto es una segunda prueba de udp", "127.0.0.1");
		System.out.println("Recibido: " + new String(cliente.recibir()));
		cliente.enviar("Esto es una tercera prueba de udp", "127.0.0.1");
		System.out.println("Recibido: " + new String(cliente.recibir()));
		cliente.cerrar();
		
	}

}
