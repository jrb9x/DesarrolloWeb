package negocio;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.Usuario;
import dao.UsuarioDaoLocal;

/**
 * Session Bean implementation class GestionUsuario
 */
@Stateless
@LocalBean
public class GestionUsuario implements GestionUsuarioRemote, GestionUsuarioLocal {

	@EJB
	private UsuarioDaoLocal usuarioDao;
    /**
     * Default constructor. 
     */
    public GestionUsuario() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Usuario loginUsuario(String nombre, String password) {
		Usuario usuario = usuarioDao.selectUsuario(nombre);
		if(usuario != null && password.equals(usuario.getPassword()))
			return usuario;
		return null;
	}
	
	public boolean aniadirUsuario(String nombre, String password){
		Usuario usuario = new Usuario(nombre, password);
		return usuarioDao.insertUsuario(usuario);
	}
	
	public boolean borrarUsuario(int id){
		return usuarioDao.deleteUsuario(id);
	}

}
