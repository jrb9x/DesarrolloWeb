package Interfaces;
import java.util.ArrayList;

public class Pruebas {

	public static void main(String[] args) {
		int x=5,y=7,x2=2,y2=3;
		Punto p1,p2,p3,p4;
		p1=new Punto(0,y);
		p2=new Punto(x,y);
		p3=new Punto(0,0);
		p4=new Punto(x,0);
		Rectangulo rectangulo1=new Rectangulo(p1,p2,p3,p4);
		Punto p12,p22,p32,p42;
		p12=new Punto(0,y2);
		p22=new Punto(x2,y2);
		p32=new Punto(0,0);
		p42=new Punto(x2,0);
		Rectangulo rectangulo2=new Rectangulo(p12,p22,p32,p42);
		Racional r1 = new Racional(2,4);
		Racional r2 = new Racional(3,6);
		
		ArrayList<Imprimible> imp= new ArrayList<Imprimible>();
		imp.add(rectangulo1);
		imp.add(rectangulo2);
		imp.add(r1);
		imp.add(r2);
		
		for (Imprimible imprimible : imp) {
			imprimible.imprimir();
		}
		
		ArrayList<Detallable> d= new ArrayList<Detallable>();
		d.add(rectangulo1);
		d.add(rectangulo2);
		d.add(p1);
		d.add(p2);
		for (Detallable detallable : d) {
			detallable.mostrarDetalle();
		}
		
	}

}
