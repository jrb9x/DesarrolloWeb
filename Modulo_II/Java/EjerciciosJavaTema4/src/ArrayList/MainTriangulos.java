package ArrayList;

public class MainTriangulos {

	public static void main(String[] args) {
		Triangulos triangulos = new Triangulos();
		Isosceles isosceles1= new Isosceles(11,9);
		Isosceles isosceles2= new Isosceles(8,5);
		Isosceles isosceles3= new Isosceles(6,3);
		
		triangulos.aniadirTriangulo(isosceles1);
		triangulos.aniadirTriangulo(isosceles2);
		triangulos.aniadirTriangulo(isosceles3);

		System.out.println("Area mas grande: " + triangulos.areaGrande());
		System.out.println("Area mas pequeña: " + triangulos.areaPequenia());
		
		triangulos.mostrarTriangulo(8,5);
		triangulos.mostrarTriangulos();
	}

}
