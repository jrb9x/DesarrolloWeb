package controlador;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import beans.Usuario;
import modelo.GestionUsuarios;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements ModelDriven<Usuario> {

	
	private GestionUsuarios gestionUsuarios = new GestionUsuarios();
	private Usuario usuario = new Usuario();
	
	@Override
	public String execute(){
		
		if(gestionUsuarios.validarUsuario(usuario)){
			
			HttpSession session = ServletActionContext.getRequest().getSession(true);
			session.setAttribute("usuario", usuario);
			
			return SUCCESS;
		}else{
			
			return LOGIN;
		}
	}
	
	public Usuario getModel(){
		return usuario;
	}
}
