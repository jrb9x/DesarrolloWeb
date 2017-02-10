package Pruebas;

public class PruebaHilos {

	public static void main(String[] args) {
		
		System.out.println("Comenzamos");
		MiHilo mh = new MiHilo();
		//mh.start(); extendiendo Thread en la clase MiHilo
		Thread thread = new Thread(mh);
		thread.start();//implementando Thread
		System.out.println("Soy el hilo principal");
	}

}
