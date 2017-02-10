package dao;

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
}
