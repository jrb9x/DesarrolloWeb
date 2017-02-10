package ArrayList;

import java.util.ArrayList;

public class Empresa {

	ArrayList<Empleado> plantilla;
	
	public Empresa(){
		plantilla = new ArrayList<>();
	}
	
	public void aniadirEmpleado(Empleado e){
		plantilla.add(e);
	}
	
	public void borrarEmpleado(Empleado e){
		plantilla.remove(e);
	}
	
	public Empleado buscarEmpleadoPorNif(String nif){
		for (Empleado empleado : plantilla) {
			if(empleado.getNif().equalsIgnoreCase(nif))
				return empleado;
		}
		return null;
	}
	
	public double mediaHijos(){
		double contadorHijos = 0.0;
		for (int i = 0; i < plantilla.size(); i++) {
			contadorHijos += plantilla.get(i).getNumHijos();
		}
		return contadorHijos/plantilla.size();
	}
	
	public void mostrarEmpleado(String nif){
		Empleado e = buscarEmpleadoPorNif(nif);
		if(e != null)
			System.out.println(e.toString());
		else
			System.out.println("Este empleado no existe!");
	}
	
	public void mostrarEmleados(){
		for (Empleado empleado : plantilla) {
			System.out.println(empleado.toString());
		}
	}
}
