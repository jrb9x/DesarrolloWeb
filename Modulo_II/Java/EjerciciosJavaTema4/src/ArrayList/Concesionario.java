package ArrayList;

import java.util.ArrayList;

public class Concesionario {

	ArrayList<Coche> plantilla;
	
	public Concesionario(){
		plantilla = new ArrayList<>();
	}
	
	public void addCoche(Coche coche){
		plantilla.add(coche);
	}
	
	public void mostrarCoches(){
		for (Coche coche : plantilla) {
			System.out.println(coche.toString());
		}
	}
	
	public Coche buscarCochesPorMarca(String m){
		for (Coche coche : plantilla) {
			if(coche.getMarca().equalsIgnoreCase(m))
				System.out.println(coche.toString());
		}
		return null;
	}
	
	public void buscarCochesMenosKm(double km){
		for (Coche coche : plantilla) {
			if(coche.getKilometros() < km){
				System.out.println(coche.toString());
			}
		}
	}
	
	public void mostrarCocheMasKm(){
		Coche masKm = null;
		for (Coche coche : plantilla) {

			masKm = coche;
			
		}
		System.out.println(masKm.toString());
	}
	
	public void mostrarCochesOrdenados(){
		
	}
}
