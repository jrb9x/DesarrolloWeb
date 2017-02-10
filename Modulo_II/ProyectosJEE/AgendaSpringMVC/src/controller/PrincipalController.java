package controller;
/*@DateTimeFormat(iso=ISODate) LocalDate fecha
 * http://www.elconspirador.com/2014/05/31/como-funciona-spring-mvc-io-parte-2-controlador/
 * */
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beans.Contacto;
import beans.Usuario;

import business.IContactoBusiness;

@Controller
@RequestMapping("/principal.do")
public class PrincipalController {

	@Autowired
	private IContactoBusiness contactoBusiness;
	
	@RequestMapping(method = RequestMethod.GET)
	public String procesar(HttpSession session, 
			HttpServletRequest req){
	
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		ArrayList<Contacto> contactos = new ArrayList<>();
		
		String mes = req.getParameter("mes");
		
		if(mes == null || mes.equals("00"))
            contactos = contactoBusiness.recuperarAgenda(usuario);
		else
			contactos = contactoBusiness.recuperarCumplenEnDe(mes, usuario);
            
		session.setAttribute("listaContactos", contactos);
        
		return "principal";
	}
}
