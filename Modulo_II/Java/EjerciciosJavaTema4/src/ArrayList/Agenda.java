package ArrayList;

import java.util.ArrayList;

public class Agenda {

	ArrayList<Persona> plantilla;
	
	public Agenda(){
		plantilla = new ArrayList<>();
	}
	
	public void aniadirPersona(Persona p){
		plantilla.add(p);
	}
	
	public void borrarPersonaPorDni(String dni){
		Persona persona = buscarPersonaPorDni(dni);
		plantilla.remove(persona);
	}
	
	public Persona buscarPersonaPorDni(String dni){
		for (Persona persona : plantilla) {
			if(persona.getDni().equalsIgnoreCase(dni))
				return persona;
		}
		return null;
	}
	
	public ArrayList<Persona> recuperarAgenda(){
		return plantilla;
	}

	public ArrayList<Persona> listarPorMesCumple(int mes) {
		ArrayList<Persona> aux = new ArrayList<Persona>();
		for (Persona persona : plantilla) {
			if(persona.getFecha().getMes() == mes){
				aux.add(persona);
			}
		}
		return aux;
	}

}
