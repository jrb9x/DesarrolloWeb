package Wait;

class Profesor extends Thread{
	
	Nota na ;
	
	Profesor ( Nota n ) {
		na = n ;
	}
	
	public void run () {
		System.out.println (" Voy a corregir los examenes");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println (" Voy a poner la nota ");
		na.dar (); // el profesor pone la nota del alumno
	}
}
