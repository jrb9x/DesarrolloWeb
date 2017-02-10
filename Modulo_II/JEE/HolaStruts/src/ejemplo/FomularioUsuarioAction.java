package ejemplo;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import beans.Usuario;

@SuppressWarnings("serial")
public class FomularioUsuarioAction extends ActionSupport implements ModelDriven<Usuario>{

	
	private Usuario usuario = new Usuario();
	
	public String execute(){
		
		System.out.println(usuario.toString());
		
		return SUCCESS;
	}

	@Override
	public Usuario getModel() {
		return usuario;
	}
}
