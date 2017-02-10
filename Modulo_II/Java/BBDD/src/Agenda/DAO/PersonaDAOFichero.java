package Agenda.DAO;

import java.util.ArrayList;

import Agenda.BEANS.Fecha;
import Agenda.BEANS.Persona;

public class PersonaDAOFichero implements PersonaDAO {

	private final String NOMBRE_FICHERO = "agenda.txt";
	private FicheroLectura lector;
	private FicheroEscritura escritor;
	
	public PersonaDAOFichero() {
		lector = new FicheroLectura();
		escritor = new FicheroEscritura(NOMBRE_FICHERO, true);
	}

	public boolean guardarPersona(Persona persona) {
		String datosPersona = persona.devolverDatos();
		escritor.escribirLinea(datosPersona);
		escritor.cerrar();
		return true;
	}

	public String recuperarPersona(String dni) {
		ArrayList<Persona> aux = recuperarTodasLasPersonas();
		for (Persona persona : aux) {
			if(persona.getDni().equalsIgnoreCase(dni))
				return persona.toString();
		}
		return "Persona no encontrada";
	}

	public ArrayList<Persona> recuperarTodasLasPersonas() {
		lector.abrir(NOMBRE_FICHERO);
		ArrayList<Persona> aux = new ArrayList<Persona>();
		String linea = lector.leerLinea();
		while (linea != null) {
            String[] split = linea.split("%");
            String nombre = split[0];
    		String apellidos = split[1];
    		String dni = split[2];
    		String telefono = split[3];
    		Fecha fecha = new Fecha(split[4],split[5],split[6]);
    		Persona persona = new Persona(nombre, apellidos, dni, telefono, fecha);
    		aux.add(persona);
    		
            linea = lector.leerLinea();
		}
		lector.cerrar();
		return aux;
	}

	public boolean borrarPersona(String dni) {
		
		ArrayList<Persona> aux = recuperarTodasLasPersonas();
		escritor.abrir(NOMBRE_FICHERO, false);
		escritor.cerrar();
		for (Persona persona : aux) {
			if(!persona.getDni().equalsIgnoreCase(dni))
				guardarPersona(persona);
		}
		return true;
	}

	@Override
	public boolean modificarPersona(Persona persona) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
