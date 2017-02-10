package business;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import beans.Contacto;
import beans.Usuario;

@Service
public interface IContactoBusiness {
	
	boolean aniadirPersona(Contacto contacto, Usuario usuario);
	boolean borrarPersonaPorId(Integer id);
	ArrayList<Contacto> recuperarAgenda(Usuario usuario);
	Contacto buscarPersonaPorId(Integer id);
	ArrayList<Contacto> recuperarCumplenEnDe(String mes, Usuario usuario);
	boolean modificarContacto(Contacto contacto);

}
