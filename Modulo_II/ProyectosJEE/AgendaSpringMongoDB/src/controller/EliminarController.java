package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import business.IContactoBusiness;

@Controller
@RequestMapping("/eliminar.do")
public class EliminarController {
	
	@Autowired
	private IContactoBusiness contactoBusiness;
	
	@RequestMapping(method = RequestMethod.GET)
    public String procesar(HttpServletRequest req){
	
		int id = new Integer(req.getParameter("idEliminar"));
		
		contactoBusiness.borrarPersonaPorId(id);
		
		return "redirect:principal.do";
	}

}
