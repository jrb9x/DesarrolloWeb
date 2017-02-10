package Wait;

class Alumno extends Thread{
	
	Nota na ; // nota del alumno
	String nom ; // nombre
	
	Alumno ( String nombre , Nota n ){
		na = n ;
		nom = nombre ;
	}

	public void run () {
		System.out.println ( nom + " esperando su nota" );
		na.esperar(); // el alumno espera la nota
		System.out.println ( nom + " recibio su nota");
	}
}