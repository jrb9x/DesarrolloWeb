package controlador;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import beans.Contacto;
import modelo.Agenda;

@SuppressWarnings("serial")
public class GestionContactoAction extends ActionSupport {

	private Agenda agenda = new Agenda();
	private Integer idModificar;
	
	@Override
	public String execute(){
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		
		if (idModificar != null) {
			Contacto contacto = agenda.buscarPersonaPorId(idModificar);
			
			session.setAttribute("contactoModificar", contacto);
			return SUCCESS;
		}
		session.setAttribute("contactoModificar", null);
		return SUCCESS;
	
	}

	public Integer getIdModificar() {
		return idModificar;
	}

	public void setIdModificar(Integer idModificar) {
		this.idModificar = idModificar;
	}
	
	
}
