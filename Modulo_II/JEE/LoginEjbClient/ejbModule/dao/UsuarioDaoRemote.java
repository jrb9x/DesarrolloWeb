package dao;

import javax.ejb.Remote;

import beans.Usuario;

@Remote
public interface UsuarioDaoRemote {

	public Usuario selectUsuario(String nombre);
	public boolean deleteUsuario(int idUsuario);
	public boolean insertUsuario(Usuario usuario);
}
