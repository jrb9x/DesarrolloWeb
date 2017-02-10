package modelo;

import beans.Usuario;
import modelo.dao.UsuarioDaoJpa;

public class GestionUsuarios {

	UsuarioDaoJpa usuarioDao;
	
	public GestionUsuarios(){
		usuarioDao = new UsuarioDaoJpa();
	}
	
	public boolean validarUsuario(Usuario usuario){
		Usuario usuarioEncontrado = usuarioDao.selectUsuario(usuario.getNombre());
		
		if(usuario != null && usuario.getNombre().equals(usuarioEncontrado.getNombre()) && usuario.getPassword().equals(usuarioEncontrado.getPassword()))
			return true;
		else
			return false;
	}
	
	public boolean registrarUsuario(Usuario usuario){
		if (usuario != null) {
			usuarioDao.insertUsuario(usuario);
			return true;
		}
		return false;
	}
}
