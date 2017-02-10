package Agenda.Negocio;

import java.util.ArrayList;
import Agenda.BEANS.Persona;
import Agenda.DAO.PersonaDAO;
import Agenda.DAO.PersonaDAOFichero;

public class Agenda {

	private PersonaDAO persona;
	
	public Agenda(){
		persona = new PersonaDAOFichero();
	}
	
	public String aniadirPersona(Persona p){
		boolean ok = this.persona.guardarPersona(p);
		if(ok == true)
			return "Persona guardada correctamente";
		else
			return "Error al guardar persona";
	}
	
	public String borrarPersonaPorDni(String dni){
		boolean ok = this.persona.borrarPersona(dni);
		if(ok == true)
			return "Persona borrada correctamente";
		else
			return "Error al borrar persona";
	}
	
	public String buscarPersonaPorDni(String dni){
		return persona.recuperarPersona(dni);
	}
	
	public ArrayList<Persona> recuperarAgenda(){
		return persona.recuperarTodasLasPersonas();
	}

}
