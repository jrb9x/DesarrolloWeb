package Agenda.DAO;

import java.util.ArrayList;
import Agenda.BEANS.Persona;

public interface PersonaDAO {

	abstract public boolean guardarPersona(Persona p);

	abstract public String recuperarPersona(String dni);

	abstract public ArrayList<Persona> recuperarTodasLasPersonas();

	abstract public boolean borrarPersona(String dni);
	
	abstract public boolean modificarPersona(Persona persona);

}


