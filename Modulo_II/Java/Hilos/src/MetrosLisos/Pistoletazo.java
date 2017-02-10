package MetrosLisos;

public class Pistoletazo {

	synchronized void esperar () {
		try {
			wait();
		}catch (InterruptedException e ){
			e.printStackTrace();
		}
	}
	
	void comenzarACorrer(int aleatorio){
		try {
			Thread.sleep(aleatorio);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	synchronized void pistoletazo (){
		notifyAll();
	}
	
}
