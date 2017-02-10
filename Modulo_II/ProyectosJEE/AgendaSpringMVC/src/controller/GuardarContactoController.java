package controller;

import java.time.LocalDate;

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
@RequestMapping("/guardar.do")
public class GuardarContactoController {

	@Autowired
    private IContactoBusiness contactoBusiness;
	
	@RequestMapping(method = RequestMethod.POST)
    public String procesar(HttpServletRequest request, HttpSession session){
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		Contacto contacto = new Contacto();
		String id = request.getParameter("id");
		
		contacto.setNombre(request.getParameter("nombre"));
		contacto.setApellidos(request.getParameter("apellidos"));
		contacto.setDni(request.getParameter("dni"));
		contacto.setTelefono(request.getParameter("telefono"));
		LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
		contacto.setFecha(fecha);
		
		if(id.equals("null")){
			contacto.setId(null);
			contactoBusiness.aniadirPersona(contacto, usuario);
		}else{
			contacto.setId(Integer.parseInt(id));
			contactoBusiness.modificarContacto(contacto);
		}
		
		return "redirect:principal.do";
	}
}
