package modelo;

import beans.Usuario;
import modelo.dao.UsuarioDAOJpa;

public class GestionUsuarios {
	
	UsuarioDAOJpa usuarioDao;
	
	public GestionUsuarios(){
		usuarioDao = new UsuarioDAOJpa();
	}

	public boolean validarUsuario(Usuario u){

		Usuario usuario = usuarioDao.recuperarUsuario(u.getNombre());

		if (usuario != null && u.getPassw().equals(usuario.getPassw()) && u.getNombre().equals(usuario.getNombre()))
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
	
}
