package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beans.Contacto;
import business.IContactoBusiness;

@Controller
@RequestMapping("/gestion.do")
public class GestionContactoController {

	@Autowired
    private IContactoBusiness contactoBusiness;
	
	@RequestMapping(method = RequestMethod.GET)
    public String procesar(HttpServletRequest req, HttpSession session){
		
		String idModificar = req.getParameter("idModificar");
		Contacto contacto = new Contacto();
		
		if (idModificar != null) {
			contacto = contactoBusiness.buscarPersonaPorId(new Integer(idModificar));
			session.setAttribute("contactoModificar", contacto);
			
			return "formularioContacto";
		}else{
		session.setAttribute("contactoModificar", contacto);
		return "formularioContacto";
		}
	}
	
}
