package controlador;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import modelo.dao.UsuarioDAOJpa;

@SuppressWarnings("serial")
public class LogoutAction extends ActionSupport {

	private UsuarioDAOJpa usaurioDao = new UsuarioDAOJpa();
	
	@Override
	public String execute(){
		HttpSession session = ServletActionContext.getRequest().getSession(false);
	    session.invalidate();
	    usaurioDao.cerrarConexion();
	    
	    return SUCCESS;
	}

	
}
