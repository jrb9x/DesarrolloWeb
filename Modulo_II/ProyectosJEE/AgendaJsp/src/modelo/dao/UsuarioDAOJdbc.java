package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Usuario;

public class UsuarioDAOJdbc implements UsuarioDAO{
	
	Connection conn = AgenteConexion.getAgenteConexion("agenda").conexion;

	public Usuario recuperarUsuario(String nombre){
		String sql = "SELECT * FROM usuarios WHERE nombre = ?";
		
		try {
			PreparedStatement selectUsuario = conn.prepareStatement(sql);
			
			selectUsuario.setString(1, nombre);
			ResultSet rs = selectUsuario.executeQuery();
			
			if (rs.next()) {
				String passw = rs.getString("password");
				Usuario usuario = new Usuario(nombre, passw);
				return usuario;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean registrarUsuario(Usuario usuario) {

		String sql = "INSERT INTO usuarios(nombre, password) VALUES (?,?)";

		try {
			PreparedStatement insertUsuario = conn.prepareStatement(sql);

			String nombre = usuario.getNombre();
			String password = usuario.getPassw();

			insertUsuario.setString(1, nombre);
			insertUsuario.setString(2, password);

			insertUsuario.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar la contacto " + usuario.getNombre() + " " + e);
			return false;
		}

		return true;

	}

}
