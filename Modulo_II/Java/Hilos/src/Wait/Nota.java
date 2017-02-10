package Wait;

class Nota {
	
	synchronized void esperar () {
		
		try { 
			wait();
		}catch (InterruptedException e ){}
	}
	
	synchronized void dar (){
		notifyAll();
	}
}