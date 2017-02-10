package modelo;

import beans.Usuario;
import modelo.dao.UsuarioDAOJpa;

public class GestionUsuarios {
	
	UsuarioDAOJpa usuarioDao;
	
	public GestionUsuarios(){
		usuarioDao = new UsuarioDAOJpa();
	}

	public boolean validarUsuario(String nombre, String passw){

		Usuario usuario = usuarioDao.recuperarUsuario(nombre);

		if (usuario != null && passw.equals(usuario.getPassw()) && nombre.equals(usuario.getNombre()))
			return true;
		
		return false;
	}

	public boolean registrarUsuario(Usuario usuario){
		if (usuario != null) {
			usuarioDao.registrarUsuario(usuario);
			return true;
		}
		return false;
	}
	
	public boolean modificarContacto(Usuario u){
		boolean modificado = usuarioDao.actualizarUsuario(u);

		return modificado;
	}
}
