package dao;

import javax.ejb.Remote;

import beans.Pelicula;
import beans.Usuario;

@Remote
public interface UsuarioDaoRemote {

	public Usuario selectUsuario(String nombre);
	public boolean deleteUsuario(int idUsuario);
	public boolean insertUsuario(Usuario usuario);
	public boolean updateUsuario(Usuario user);
	public boolean updateFavoritos(Pelicula pelicula, String nombre);
}
