package modelo;

import java.util.ArrayList;
import beans.Contacto;
import beans.Usuario;
import modelo.dao.ContactoDao;
import modelo.dao.ContactoDaoJpa;

public class Agenda {

	private ContactoDao contactoDao;
	
	public Agenda(){
		contactoDao = new ContactoDaoJpa();
	}
	
	public boolean aniadirPersona(Contacto contacto, Usuario usuario){
		boolean aniadido = contactoDao.guardarContacto(contacto, usuario);

		return aniadido;
	}
	
	public boolean borrarPersonaPorId(int id){
		boolean borrado = contactoDao.borrarContacto(id);

		return borrado;
	}
	
	public ArrayList<Contacto> recuperarAgenda(Usuario usuario){
		ArrayList<Contacto> lista = contactoDao.ListarContactosDe(usuario);
		return lista;
	}
	
	public Contacto buscarPersonaPorId(int id){
		return contactoDao.recuperarPersona(id);
	}

	public ArrayList<Contacto> recuperarCumplenEnDe(String mes, Usuario usuario){
		ArrayList<Contacto> contactos = contactoDao.ListarContactosDe(usuario);
		ArrayList<Contacto> contactosAux = new ArrayList<Contacto>();;
		for (Contacto persona : contactos) {
			if(mes.equals(persona.getFecha().getMes())){
				contactosAux.add(persona);
			}
		}
		return contactosAux;
	}

}
