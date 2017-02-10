package Ejercicios;

public class Ejercicio1 {

	public static void main(String[] args) {
		int N[];
		N = new int [100];
		for(int i=0;i<N.length;i++){
			N[i]=i;
		}
		for(int i=N.length-1;i>=0;i--){
			System.out.println(N[i]);
		}

	}

}