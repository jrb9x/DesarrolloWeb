package controller;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beans.Tarea;
import beans.Usuario;
import model.business.ITareaBusiness;

@Controller
@RequestMapping("/realizar.do")
public class RealizarTareaController {

	@Autowired
	ITareaBusiness tareaBusiness;
	
	@RequestMapping(method=RequestMethod.POST)
	public String procesar(HttpServletRequest request){
		HttpSession sesion = request.getSession(false);
		Usuario usuario = (Usuario) sesion.getAttribute("usuario");
		
		int id = Integer.parseInt(request.getParameter("id"));
		Tarea tarea = tareaBusiness.recuperarTarea(id);
		
		tarea.setId(id);
		tarea.setRealizada(true);
		tarea.setFecha(LocalDate.now());
		tarea.setUsuario(usuario);
		
		tareaBusiness.actualizarTarea(tarea);
		
		return "redirect:principal.do";
	}
}
