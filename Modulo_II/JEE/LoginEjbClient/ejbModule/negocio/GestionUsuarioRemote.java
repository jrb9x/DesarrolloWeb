package negocio;

import javax.ejb.Remote;

import beans.Usuario;

@Remote
public interface GestionUsuarioRemote {

	public Usuario loginUsuario(String nombre, String password);
	public boolean aniadirUsuario(String nombre, String password);
	public boolean borrarUsuario(int id);
}
