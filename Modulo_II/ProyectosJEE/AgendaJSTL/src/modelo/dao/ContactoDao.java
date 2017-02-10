package modelo.dao;

import java.util.ArrayList;

import beans.Contacto;
import beans.Usuario;

public interface ContactoDao {

	abstract public boolean guardarContacto(Contacto contacto, Usuario usuario);
	public Contacto recuperarPersona(int id);
	abstract public ArrayList<Contacto> ListarContactosDe(Usuario usuario);
	abstract public boolean borrarContacto(int id);
}


