package negocio;

import javax.ejb.Local;

import beans.Usuario;

@Local
public interface GestionUsuarioLocal {

	public Usuario loginUsuario(String nombre, String password);
	public boolean aniadirUsuario(String nombre, String password);
	public boolean borrarUsuario(int id);
}
