package Matrices;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		int max = 0, min = 5;
		int [][] M = {{6,7,5,8,8,4,15,25}, 
				{6,7,5,8,8,4,15,25}, 
				{6,1,5,8,8,4,15,25}, 
				{6,7,5,8,8,4,15,25}, 
				{6,7,5,8,8,4,105,25},  
				{6,7,5,8,8,4,15,25}};
		
		for (int i = 0; i < 6; i++){
			for (int j = 0; j < 8; j++) {
				if(M[i][j] > max){
					max = M[i][j];
				}
				else if(M[i][j] < min){
					min = M[i][j];
				}
			}
			
		}
		System.out.println("Numero maximo: " + max);
		System.out.println("Numero minimo: " + min);

	}

}
