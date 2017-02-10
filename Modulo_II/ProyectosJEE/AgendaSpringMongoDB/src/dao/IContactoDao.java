package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import beans.Contacto;
import beans.Usuario;

@Repository
public interface IContactoDao {

	boolean guardarContacto(Contacto contacto, Usuario usuario);
	Contacto recuperarPersona(Integer id);
	List<Contacto> ListarContactosDe(Usuario usuario);
	boolean borrarContacto(Integer id);
	boolean actualizarContacto(Contacto contacto);
}
