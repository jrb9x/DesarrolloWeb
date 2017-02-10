package Relevos;

public class Atleta extends Thread {

	String nombre;
	
	public Atleta(String string) {
	
		nombre = string;
	}
	
	public void run(){
		
		System.out.println(nombre + " esperando");
		esperarTestigo();
		System.out.println(nombre + " corriendo...");
		long time=System.currentTimeMillis();
		correr();
		soltarTestigo();
		long total= System.currentTimeMillis()-time;
		System.out.println(nombre + " suelta el testigo, ha corrido durante"+(total/1000));

	}
	public int tiempoCarrera(){
		double result = Math.random();
		int resultFinal = (int) ((result * 2 + 9) * 1000);
		return resultFinal;
	}
	
	public void esperarTestigo(){
		synchronized(Carrera.testigo){
			try {
				Carrera.testigo.wait();
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public void correr(){
		try {
			Thread.sleep(tiempoCarrera());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void soltarTestigo(){
		synchronized (Carrera.testigo) {
			Carrera.testigo.notify();
		}
	}

}
