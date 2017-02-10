package controlador;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import beans.Contacto;

import beans.Usuario;
import modelo.Agenda;

@SuppressWarnings("serial")
public class GuardarContactoAction extends ActionSupport implements ModelDriven<Contacto> {

	private Agenda agenda = new Agenda();
	private Contacto contacto = new Contacto();
	private String fecha_cumple;
	
	@Override
	public String execute(){
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		contacto.setFecha(LocalDate.parse(fecha_cumple));
		
		Integer id = contacto.getId();
		
		if(id == null){			
			agenda.aniadirPersona(contacto, usuario);
			
		}else{
			agenda.modificarContacto(contacto);
		}
		
		return SUCCESS;
	}

	@Override
	public Contacto getModel() {
		// TODO Auto-generated method stub
		return contacto;
	}

	public String getFecha_cumple() {
		return fecha_cumple;
	}

	public void setFecha_cumple(String fecha_cumple) {
		this.fecha_cumple = fecha_cumple;
	}
	
	
}
