package Pruebas;

public class AplicHilo1 {

	public static void main(String args[]){
		Tortuga tortuga = new Tortuga();
		Thread liebre=new Thread(new Liebre());
		//Prioridad en el procesador
		liebre.setPriority(1);
		tortuga.setPriority(10);

		tortuga.start();
		liebre.start();
	}
}