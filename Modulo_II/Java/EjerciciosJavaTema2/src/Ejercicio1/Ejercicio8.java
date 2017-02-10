package Ejercicio1;

public class Ejercicio8 {

	public static void main(String[] args) {
		
		double salario = 0, deduccionHijos, ImpuestoRenta;
		int hijos = 0;
		
		try{
			salario = new Integer(args[0]);
			hijos = new Integer(args[0]);
		}
		catch(Exception e){
			System.out.println("Error al introducir los datos!");
		}
		
		if(hijos == 0){
			deduccionHijos = salario;
		}
		else if(hijos == 1 || hijos == 2){
			deduccionHijos = salario * 0.05;
		}
		else{
			deduccionHijos = salario * 0.15;
		}
		
		ImpuestoRenta = deduccionHijos * 0.15;
		System.out.println("El impuesto sobre la Renta es:" + ImpuestoRenta);

	}
}
