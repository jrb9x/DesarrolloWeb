package modelo.dao;

import java.util.ArrayList;

import beans.Contacto;
import beans.Usuario;

public interface ContactoDao {

	public boolean guardarContacto(Contacto contacto, Usuario usuario);
	public Contacto recuperarPersona(Integer id);
	public ArrayList<Contacto> ListarContactosDe(Usuario usuario);
	public boolean borrarContacto(Usuario usuario,Integer id);
	public boolean actualizarContacto(Contacto contacto);
}


