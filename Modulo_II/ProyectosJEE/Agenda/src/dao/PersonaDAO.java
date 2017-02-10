package dao;

import java.util.ArrayList;

import beans.Persona;

public interface PersonaDAO {

	abstract public boolean guardarContacto(Persona persona, String usuario);
	public Persona recuperarPersona(int id);
	abstract public ArrayList<Persona> ListarContactosDe(String usuario);
	abstract public boolean borrarContacto(int id);
	abstract public boolean modificarContacto(Persona persona);
}


