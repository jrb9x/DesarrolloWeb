package Flujo;

public class mainFlujo {

	public static void main(String[] args) {
		
		FicheroEscritura escritor = new FicheroEscritura("pruebas.txt");
		escritor.escribirLinea("esto es una prueba para escribir");
		escritor.escribirLinea("esto es una prueba para escribir");
		escritor.escribirLinea("esto es una prueba para escribir");
		escritor.cerrar();
		
		FicheroLectura lectura = new FicheroLectura();
		lectura.abrir("prueba.txt");
        System.out.println(lectura.leerCadena());
        System.out.println(lectura.leerCadena());
        System.out.println(lectura.leerCadena());
		lectura.cerrar();
	}

}
