package controlador;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import beans.Contacto;
import beans.Usuario;
import modelo.Agenda;

@SuppressWarnings("serial")
public class PrincipalAction extends ActionSupport {

	private Agenda agenda = new Agenda();
	private String mes;
	
	@Override
	public String execute(){
		HttpSession session = ServletActionContext.getRequest().getSession(false);
	
		ArrayList<Contacto> contactos;
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		if(mes == null)
        	contactos = agenda.recuperarAgenda(usuario);
        
		else if(mes.equals("00"))
			contactos = agenda.recuperarAgenda(usuario);
        
		else
			contactos = agenda.recuperarCumplenEnDe(mes, usuario);
		
		session.setAttribute("listaContactos", contactos);

		return SUCCESS;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}
	
}
