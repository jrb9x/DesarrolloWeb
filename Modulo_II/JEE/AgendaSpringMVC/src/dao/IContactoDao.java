package dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import beans.Contacto;
import beans.Usuario;

@Repository
public interface IContactoDao {

	boolean guardarContacto(Contacto contacto, Usuario usuario);
	Contacto recuperarPersona(Integer id);
	ArrayList<Contacto> ListarContactosDe(Usuario usuario);
	boolean borrarContacto(Integer id);
	boolean actualizarContacto(Contacto contacto);
}
