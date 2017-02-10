package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Fecha;
import beans.Persona;

public class PersonaDAOJdbc implements PersonaDAO {
	
	Connection conn = AgenteConexion.getAgenteConexion("agenda").conexion;

	public boolean guardarContacto(Persona persona, String usuario) {

		boolean success = false;

        String sql = "INSERT INTO contactos(nombre,apellidos,dni,telefono,fecha,nombre_usuario) VALUES (?,?,?,?,?,?)";
        
        try {
            PreparedStatement insertPersona = conn.prepareStatement(sql);

            String nombre = persona.getNombre();
            String apellidos = persona.getApellidos();
            String dni = persona.getDni();
            String fecha = persona.getFecha().toString();
            String telefono = persona.getTelefono();

            insertPersona.setString(1, nombre);
            insertPersona.setString(2, apellidos);
            insertPersona.setString(3, dni);
            insertPersona.setString(4, telefono);
            insertPersona.setString(5, fecha);
            insertPersona.setString(6, usuario);

            insertPersona.executeUpdate();
            success = true;
        } catch (SQLException e) {
        	e.printStackTrace();
            success = false;
        }

        return success;
    }
	
	public Persona recuperarPersona(int id) {
		Persona persona = null;
		
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM contactos WHERE id_persona="+ id );
			
			while (rs.next()) {
				String nombre = rs.getString("nombre");
		    	String apellidos = rs.getString("apellidos");
		    	String dni = rs.getString("dni");
		    	String telefono = rs.getString("telefono");
		    	Fecha fecha = new Fecha(rs.getString("fecha"));
		    	 
		    	persona = new Persona(id ,nombre, apellidos, dni,telefono, fecha);
		    	return persona;
			}
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return persona;
	}
	
	public ArrayList<Persona> ListarContactosDe(String usuario) {
		
		ArrayList<Persona> contactos = new ArrayList<Persona>();
		
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM contactos WHERE nombre_usuario=\""+ usuario + "\" ORDER BY nombre");
			
			while (rs.next()) {
				int id = rs.getInt("id_persona");
	            String nombre = rs.getString("nombre");
	    		String apellidos = rs.getString("apellidos");
	    		String dni = rs.getString("dni");
	    		String telefono = rs.getString("telefono");
	    		Fecha fecha = new Fecha(rs.getString("fecha"));
	    		Persona persona = new Persona(id, nombre, apellidos, dni, telefono, fecha);
	    		contactos.add(persona);
			}
			st.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contactos;
	}

	public boolean borrarContacto(int id) {
		boolean borrado = false;
		
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("DELETE FROM contactos WHERE id_persona=" + id );
			st.close();
			borrado = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			borrado = false;
		}
		
		return borrado;
	}
	
	public boolean modificarContacto(Persona persona){
		
		boolean modificar = false;

        String sql = "UPDATE contactos SET nombre = ?, apellidos = ?, dni = ?, telefono = ?, fecha = ? WHERE id_persona= ?";
		
		try {
			PreparedStatement modificarContacto = conn.prepareStatement(sql);
			
			String nombre = persona.getNombre();
            String apellidos = persona.getApellidos();
            String dni = persona.getDni();
            String telefono = persona.getTelefono();
            String fecha = persona.getFecha().toString();
            String id = Integer.toString(persona.getId());
			
			modificarContacto.setString(1, nombre);
			modificarContacto.setString(2, apellidos);
			modificarContacto.setString(3, dni);
			modificarContacto.setString(4, telefono);
			modificarContacto.setString(5, fecha);
			modificarContacto.setString(6, id);
            
			modificarContacto.executeUpdate();

			modificar = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modificar;
	}
	
}
