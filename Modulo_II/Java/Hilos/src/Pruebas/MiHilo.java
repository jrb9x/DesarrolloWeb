package Pruebas;

public class MiHilo implements Runnable{
					/*
				  **implements Runnable
				  **extends Thread
				   */
	@Override
	public void run(){
		/*proceso muy largo y costoso*/
		System.out.println("comenzamos hilo hijo");
		long d = 0;
		for (long i = 0; i < 999999999l; i++) {
			d += i;
		}
		System.out.println("he acabado, soy el hilo hijo: " + d);
	}
}
