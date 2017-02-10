package Agenda.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Agenda.BEANS.Fecha;
import Agenda.BEANS.Persona;
import Agenda.DAO.AgenteConexion;

public class PersonaDAOJdbc implements PersonaDAO {
	
	Connection conn = AgenteConexion.getAgenteConexion("agenda").conexion;

	public boolean guardarPersona(Persona persona) {

		try {
			Statement st = conn.createStatement();
			st.executeUpdate("INSERT INTO persona VALUES(\"" + persona.getNombre() +"\",\""+ 
							persona.getApellidos() +"\",\""+
							persona.getDni() +"\",\""+
							persona.getTelefono() +"\",\""+
							persona.getFecha().getDia() +"\",\""+
							persona.getFecha().getMes() +"\",\""+
							persona.getFecha().getAnio() +"\")");
			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public ArrayList<Persona> recuperarTodasLasPersonas() {
		
		ArrayList<Persona> aux = new ArrayList<Persona>();
		
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM persona");
			
			while (rs.next()) {
	            String nombre = rs.getString("nombre");
	    		String apellidos = rs.getString("apellidos");
	    		String dni = rs.getString("dni");
	    		String telefono = rs.getString("telefono");
	    		Fecha fecha = new Fecha(rs.getString("dia"),rs.getString("mes"),rs.getString("anio"));
	    		Persona persona = new Persona(nombre, apellidos, dni, telefono, fecha);
	    		aux.add(persona);
			}
			st.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux;
	}
	
	public String recuperarPersona(String dni) {
		Persona persona = null;
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM persona WHERE dni=\"" + dni +"\"");
			while (rs.next()) {
	            String nombre = rs.getString("nombre");
	    		String apellidos = rs.getString("apellidos");
	    		String telefono = rs.getString("telefono");
	    		Fecha fecha = new Fecha(rs.getString("dia"),rs.getString("mes"),rs.getString("anio"));
	    		persona = new Persona(nombre, apellidos, dni, telefono, fecha);
			}
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return persona.toString();
	}

	public boolean borrarPersona(String dni) {
		
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("DELETE FROM persona WHERE dni=\"" + dni +"\"");
			st.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean modificarPersona(Persona persona){
		Statement st;
		try {
			st = conn.createStatement();
			st.executeUpdate("UPDATE persona SET nombre=\" " + persona.getNombre() +"\","
					+ "apellidos =\"" + persona.getApellidos() +"\","
					+ "dni =\"" + persona.getDni() +"\","
					+ "telefono =\"" + persona.getTelefono() +"\","
					+ "dia =\"" + persona.getFecha().getDia() +"\","
					+ "mes =\"" + persona.getFecha().getMes() +"\","
					+ "anio =\"" + persona.getFecha().getAnio() +"\""
					+ "WHERE dni =\"" + persona.getDni() +"\"");
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
}
