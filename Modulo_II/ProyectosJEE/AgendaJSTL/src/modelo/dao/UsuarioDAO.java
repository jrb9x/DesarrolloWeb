package modelo.dao;

import beans.Usuario;

public interface UsuarioDAO {
	public Usuario recuperarUsuario(String nombre);
	public boolean registrarUsuario(Usuario usuario);
	public boolean actualizarUsuario(Usuario usuario);
	public void cerrarConexion();
}
