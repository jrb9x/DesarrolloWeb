package Relevos;

public class Carrera {
	
	public static Object testigo = new Object();
	public Atleta[] atletas;
		
	public Carrera(Atleta[] atletas2) {
		this.atletas=atletas2;
	}

	public void realizarCarrera() {
		prepararCorredores();
		long tiempo= System.currentTimeMillis();
		iniciarCarrera();
		esperarAlUltimoAtleta();
		long total= System.currentTimeMillis()-tiempo;
		System.out.println("Finalizada carrera en "+ (total/1000)+" segundos");
		
	}

	private void prepararCorredores() {
		for (int i = 0; i < atletas.length; i++) {
			atletas[i].start();
		}
		
	}

	private  void esperarAlUltimoAtleta() {
		synchronized(testigo){
			try {
				testigo.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private  void iniciarCarrera() {
		
		try {
			Thread.sleep(200);
			synchronized(testigo){
				testigo.notify();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
