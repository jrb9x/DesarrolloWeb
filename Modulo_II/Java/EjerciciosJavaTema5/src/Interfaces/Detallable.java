package Interfaces;

public interface Detallable {

	public  default void mostrarDetalle(){
		System.out.println("Implementacion por defecto");
	}
	
}
