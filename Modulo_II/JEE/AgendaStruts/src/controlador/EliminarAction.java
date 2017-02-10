package controlador;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import beans.Usuario;
import modelo.Agenda;

@SuppressWarnings("serial")
public class EliminarAction extends ActionSupport{

	Agenda agenda = new Agenda();
	private Integer idEliminar;
	
	@Override
	public String execute(){
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		agenda.borrarPersonaPorId(usuario,idEliminar);
		
		return SUCCESS;
		
	}

	public Integer getIdEliminar() {
		return idEliminar;
	}

	public void setIdEliminar(Integer idEliminar) {
		this.idEliminar = idEliminar;
	}
	
	
	
}
