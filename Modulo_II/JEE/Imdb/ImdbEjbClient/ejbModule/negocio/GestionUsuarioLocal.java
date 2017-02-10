package negocio;

import java.util.List;

import javax.ejb.Local;

import beans.Pelicula;
import beans.Usuario;

@Local
public interface GestionUsuarioLocal {

	public Usuario loginUsuario(String nombre, String password);
	public boolean aniadirUsuario(String nombre, String password, List<Pelicula> listaPeliculasFavoritas);
	public boolean modificarUsuario(Usuario usuario);
	public boolean borrarUsuario(int id);
}
