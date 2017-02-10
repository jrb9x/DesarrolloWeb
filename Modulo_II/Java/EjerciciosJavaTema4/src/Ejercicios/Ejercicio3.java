package Ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio3 {

	private Scanner entrada;

	public static void main(String[] args) {

		Ejercicio3 a = new Ejercicio3();
		a.mostrar();
		
	}
	
	public void mostrar(){
		int longitud = solicitarNumero("Introduce el tamaño del Array: ");
		int arrayNumeros[] = new int [longitud];
		
		for(int i = 0; i < arrayNumeros.length; i++){
			arrayNumeros[i] = (int) Math.floor(Math.random()*300);
			System.out.print("["+arrayNumeros[i] +"]");
		}
		
		int digito = solicitarNumero("Introduce el ultimo digito: ");
		int arrayNumerosDigito[] = new int [longitud];
		int j = 0;
		
		for(int i = 0; i < arrayNumeros.length; i++){
			if(arrayNumeros[i]%10 == digito){
				arrayNumerosDigito[j] = arrayNumeros[i];
				j++;
			}
		}
		
		for (int i = 0; i < j; i++) {
			System.out.print("["+arrayNumerosDigito[i] +"]");
		}
		
	}
	
	public int solicitarNumero(String mensaje){
		boolean isError = true;
		int numero = 0;
		do{
			try{
				entrada = new Scanner(System.in);
				System.out.println(mensaje);
				numero = entrada.nextInt();
				isError = false;
			}
			catch(InputMismatchException e){
				System.out.println("Error al introducir datos");
			}
		}while(isError);
		
		return numero;
	}

}
