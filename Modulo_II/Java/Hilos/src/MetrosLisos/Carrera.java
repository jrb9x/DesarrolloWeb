package MetrosLisos;

public class Carrera extends Thread{
	
	static Pistoletazo pistoletazo = new Pistoletazo ();
	
	public static void main ( String args[] ){
		try {
			Carrera juez = new Carrera();
			Atleta[] atletas = { new Atleta ( "911", pistoletazo),
					new Atleta ( "912", pistoletazo ),
					new Atleta ( "913", pistoletazo),
					new Atleta ( "914", pistoletazo ),
					new Atleta ( "915", pistoletazo),
					new Atleta ( "916", pistoletazo ),
					new Atleta ( "917", pistoletazo),
					new Atleta ( "918", pistoletazo )};
			
			for (int i = 0; i < atletas.length; i++) {
				atletas[i].start();
			}
			
			juez.pistoletazo();
			
		}catch (Exception e) {
			System.out.println ( e.toString() );
		}
	}
	
	synchronized void pistoletazo (){
		try {
			Thread.sleep(1000);
			System.out.println ("Preparados...");
			Thread.sleep(1000);
			System.out.println ("Listos...");
			Thread.sleep(1000);
			System.out.println ("YA!");
			pistoletazo.pistoletazo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
