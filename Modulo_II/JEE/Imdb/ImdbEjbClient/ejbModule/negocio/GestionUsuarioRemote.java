package negocio;

import java.util.List;

import javax.ejb.Remote;

import beans.Pelicula;
import beans.Usuario;

@Remote
public interface GestionUsuarioRemote {

	public Usuario loginUsuario(String nombre, String password);
	public boolean aniadirUsuario(String nombre, String password, List<Pelicula> listaPeliculasFavoritas);
	public boolean modificarUsuario(Usuario usuario);
	public boolean borrarUsuario(int id);
}
