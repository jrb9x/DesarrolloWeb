package controlador;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import beans.Usuario;
import modelo.GestionUsuarios;

@SuppressWarnings("serial")
public class RegistroAction extends ActionSupport implements ModelDriven<Usuario> {

	private Usuario usuario = new Usuario();
    private GestionUsuarios usuarioNuevo = new GestionUsuarios();

    @Override
	public String execute(){
    	String nombre = usuario.getNombre();
        String passw = usuario.getPassw();
        
        boolean registrado = usuarioNuevo.registrarUsuario(new Usuario(nombre,passw));

        if(registrado){
            return SUCCESS;
        }
        else{
        	return LOGIN;
        }
    }
	
	@Override
	public Usuario getModel() {
		return usuario;
	}

}
