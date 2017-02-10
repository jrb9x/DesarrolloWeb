package dao;

import javax.ejb.Local;

import beans.Usuario;

@Local
public interface UsuarioDaoLocal {

	public Usuario selectUsuario(String nombre);
	public boolean deleteUsuario(int idUsuario);
	public boolean insertUsuario(Usuario usuario);
}
