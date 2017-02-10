package MetrosLisos;

public class Atleta extends Thread{
	
	String dorsal;
	Pistoletazo pistoletazo;
	
	public Atleta(String d, Pistoletazo p){
		dorsal = d;
		pistoletazo = p;
	}
	
	public void run(){
		
		System.out.println("Esperando la salida " + dorsal );
		pistoletazo.esperar();
		System.out.println(dorsal + " comienza a correr");
		int aleatorio = (int)(Math.random()*(9000 - 11000)+ 11000);
		pistoletazo.comenzarACorrer(aleatorio);
		System.out.println(dorsal + " termina en " + aleatorio +" ms.");
	}

}
