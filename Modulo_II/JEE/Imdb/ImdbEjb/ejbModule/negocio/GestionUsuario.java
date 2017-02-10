package negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.Pelicula;
import beans.Usuario;
import dao.UsuarioDao;

/**
 * Session Bean implementation class GestionUsuario
 */
@Stateless
@LocalBean
public class GestionUsuario implements GestionUsuarioRemote, GestionUsuarioLocal {

	@EJB
	private UsuarioDao usuarioDao;

	public Usuario loginUsuario(String nombre, String password) {
		Usuario usuario = usuarioDao.selectUsuario(nombre);
		if(usuario != null && password.equals(usuario.getPassword()))
			return usuario;
		return null;
	}
	
	public boolean aniadirUsuario(String nombre, String password, List<Pelicula> listaPeliculasFavoritas){
		Usuario usuario = new Usuario(nombre, password, listaPeliculasFavoritas);
		return usuarioDao.insertUsuario(usuario);
	}
	
	public boolean modificarUsuario(Usuario usuario){
		return usuarioDao.updateUsuario(usuario);
	}
	
	public boolean borrarUsuario(int id){
		return usuarioDao.deleteUsuario(id);
	}

}
