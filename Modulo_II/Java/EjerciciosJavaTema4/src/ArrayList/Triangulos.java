package ArrayList;

import java.util.ArrayList;

public class Triangulos {

	ArrayList<Isosceles> plantilla;
	
	public Triangulos(){
		plantilla = new ArrayList<>();
	}
	
	public void aniadirTriangulo(Isosceles e){
		plantilla.add(e);
	}
	
	public Isosceles areaGrande(){
		Isosceles isoscelesGrande = null;
		double areaGrande = 0;
		for (Isosceles isosceles : plantilla) {
			if(areaGrande < isosceles.calcularArea()){
				areaGrande = isosceles.calcularArea();
				isoscelesGrande = isosceles;
			}
		}
		return isoscelesGrande;
	}
	
	public Isosceles areaPequenia(){
		Isosceles isoscelesPequenio = null;
		double areaGrande = 1000;
		for (Isosceles isosceles : plantilla) {
			if(areaGrande > isosceles.calcularArea()){
				areaGrande = isosceles.calcularArea();
				isoscelesPequenio = isosceles;
			}
		}
		return isoscelesPequenio;
	}
	
	public Isosceles buscarTriangulo(double base, double altura){
		for (Isosceles isosceles : plantilla) {
			if(isosceles.getBase() == base && isosceles.getAltura() == altura)
				return isosceles;
		}
		return null;
	}
	
	public void mostrarTriangulo(double base, double altura){
		Isosceles i = buscarTriangulo(base, altura);
		if(i != null){
			System.out.println(i.toString());
			System.out.println("Area = " + i.calcularArea());
			System.out.println("Perimetro = " + i.calcularPerimetro());
		}
		else
			System.out.println("Este triangulo no existe!");
	}
	
	public void mostrarTriangulos(){
		for (Isosceles isosceles : plantilla) {
			System.out.println(isosceles.toString());
			System.out.println("Area = " + isosceles.calcularArea());
			System.out.println("Perimetro = " + isosceles.calcularPerimetro());
		}
	}
}
