package negocio;

import java.util.ArrayList;
import beans.Persona;
import dao.PersonaDAO;
import dao.PersonaDAOJdbc;

public class Agenda {

	private PersonaDAO persona;
	
	public Agenda(){
		persona = new PersonaDAOJdbc();
	}
	
	public boolean aniadirPersona(Persona p, String usuario){
		boolean aniadido = persona.guardarContacto(p, usuario);

		return aniadido;
	}
	
	public boolean borrarPersonaPorId(int id){
		boolean borrado = persona.borrarContacto(id);

		return borrado;
	}
	
	public boolean modificarPersona(Persona p){
		boolean modificado = persona.modificarContacto(p);

		return modificado;
	}
	
	public ArrayList<Persona> recuperarAgenda(String usuario){
		ArrayList<Persona> lista = persona.ListarContactosDe(usuario);
		return lista;
	}
	
	public Persona buscarPersonaPorId(int id){
		return persona.recuperarPersona(id);
	}

	public ArrayList<Persona> recuperarCumplenEnDe(String mes, String usuario){
		ArrayList<Persona> contactos = persona.ListarContactosDe(usuario);
		ArrayList<Persona> contactosAux = new ArrayList<Persona>();;
		for (Persona persona : contactos) {
			if(mes.equals(persona.getFecha().getMes())){
				contactosAux.add(persona);
			}
		}
		return contactosAux;
	}

}
