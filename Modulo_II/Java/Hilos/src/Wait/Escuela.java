package Wait;

public class Escuela {
	public static void main ( String args[] ){

		try {
			Nota laNota = new Nota ();
			Profesor p = new Profesor ( laNota );
			Alumno a = new Alumno ( "Javier", laNota);
			Alumno b = new Alumno ( "Jose", laNota );
			// Empezamos la ejecución
			a.start();
			b.start();
			p.start();
			a.join();// El join hace que esperemos a que “a” acabe para continuar nuestra ejecución.
			b.join();
			p.join();
			System.out.println("Se cierra la escuela");
		}
		catch ( Exception e ){
			System.out.println ( e.toString() );
		}
	}
}