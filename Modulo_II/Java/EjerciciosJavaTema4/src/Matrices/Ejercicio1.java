package Matrices;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		final int FILAS = 5, COLUMNAS = 4;
		
		int [][] M = {{6,7,5,8}, {3,8,4,1}, {1,0,2,1}, {9,5,2,1}};
		int [][] N = {{6,7,5,2}, {3,8,4,3}, {1,0,2,0}, {9,5,2,4}};
		int [][] S = new int[FILAS][COLUMNAS];
		
		for (int i = 0; i < FILAS; i++){
			for (int j = 0; j < COLUMNAS; j++) {
				S[i][j] = M[i][j] + N[i][j];
				System.out.print(S[i][j] + "  ");
			}
			System.out.println();
		}
		

	}


}
