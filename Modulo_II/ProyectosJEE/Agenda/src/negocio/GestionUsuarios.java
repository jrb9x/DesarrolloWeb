package negocio;

import beans.Usuario;
import dao.UsuarioDAOJdbc;

public class GestionUsuarios {
	
	UsuarioDAOJdbc usuarioDao;
	
	public GestionUsuarios(){
		usuarioDao = new UsuarioDAOJdbc();
	}

	public boolean validarUsuario(String nombre, String passw){
		
		Usuario usuario = usuarioDao.recuperarUsuario(nombre);
		if(passw.equals(usuario.getPassw()))
			return true;
		else
			return false;
	}
}
