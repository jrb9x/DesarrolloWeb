package Agenda.DAO;

public class FactoriaPersonaDAO {

	public static PersonaDAO getPersonaDAO() {
		
		FicheroLectura lector = new FicheroLectura();
		lector.abrir("agenda.cfg");
		
		String linea = lector.leerLinea().trim();
		lector.cerrar();
		
		if(linea.equals("bbdd"))
			return new PersonaDAOJdbc();
		else
			return new PersonaDAOFichero();
	}
		
}
