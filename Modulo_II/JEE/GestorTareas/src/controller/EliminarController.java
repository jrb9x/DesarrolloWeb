package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.business.ITareaBusiness;

@Controller
@RequestMapping("/eliminar.do")
public class EliminarController {

	@Autowired
	ITareaBusiness tareasBusiness;
	
	@RequestMapping(method=RequestMethod.POST)
	public String procesar(HttpServletRequest request){
		
		int id = Integer.parseInt(request.getParameter("id"));
		tareasBusiness.borrarTarea(id);
		
		return "redirect:principal.do";
	}
}
