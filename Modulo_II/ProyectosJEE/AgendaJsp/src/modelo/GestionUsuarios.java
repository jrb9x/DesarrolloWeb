package modelo;

import beans.Usuario;
import modelo.dao.UsuarioDAOJdbc;

public class GestionUsuarios {
	
	UsuarioDAOJdbc usuarioDao;
	
	public GestionUsuarios(){
		usuarioDao = new UsuarioDAOJdbc();
	}

	public boolean validarUsuario(String nombre, String passw){

		Usuario usuario = usuarioDao.recuperarUsuario(nombre);

		if (usuario != null){
			if(passw.equals(usuario.getPassw()) && nombre.equals(usuario.getNombre()))
				return true;
			else
				return false;
		}
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
