package modelo.dao;

import beans.Usuario;

public interface UsuarioDao {

	public Usuario selectUsuario(String nombre);
	public boolean insertUsuario(Usuario usuario);
	public void cerrarConexion();
}
