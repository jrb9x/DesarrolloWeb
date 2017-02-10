package Agenda.Negocio;

import java.util.ArrayList;
import Agenda.BEANS.Persona;
import Agenda.DAO.FactoriaPersonaDAO;
import Agenda.DAO.PersonaDAO;

public class Agenda {

	private PersonaDAO persona;
	
	public Agenda(){
		persona = FactoriaPersonaDAO.getPersonaDAO();
	}
	
	public String aniadirPersona(Persona p){
		boolean ok = persona.guardarPersona(p);
		if(ok == true)
			return "Persona guardada correctamente";
		else
			return "Error al guardar persona";
	}
	
	public String borrarPersonaPorDni(String dni){
		boolean ok = persona.borrarPersona(dni);
		if(ok == true)
			return "Persona borrada correctamente";
		else
			return "Error al borrar persona";
	}
	
	public String buscarPersonaPorDni(String dni){
		return persona.recuperarPersona(dni);
	}
	
	public String modificarPersonaPorDni(Persona p){
		boolean ok = persona.modificarPersona(p);
		if(ok == true)
			return "Persona actualizada";
		else
			return "Error al modificar persona";
	}
	
	public ArrayList<Persona> recuperarAgenda(){
		return persona.recuperarTodasLasPersonas();
	}

}
