package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beans.Tarea;
import model.business.ITareaBusiness;

@Controller
@RequestMapping("/principal.do")
public class PrincipalController {

	@Autowired
	private ITareaBusiness tareaBusiness;
	
	@RequestMapping(method = RequestMethod.GET)
	public String procesarTareas(HttpServletRequest req){
		HttpSession session = req.getSession(false);
		ArrayList<Tarea> listaTareas = new ArrayList<>();
		
		String realizada = req.getParameter("realizada");
		
		if(realizada == null || realizada.equals("0") )
			listaTareas = tareaBusiness.recuperarTodasTareas();
      
		else if(realizada.equals("1"))
			listaTareas = tareaBusiness.recuperarTareasPor(true);
        else
        	listaTareas = tareaBusiness.recuperarTareasPor(false);
        
		session.setAttribute("listaTareas", listaTareas);
        
		return "principal";
	}
}
