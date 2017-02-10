package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beans.Tarea;
import model.business.ITareaBusiness;

@Controller
@RequestMapping("/agregar.do")
public class AgregarTareaController {

	@Autowired
	ITareaBusiness tareaBusiness;
	
	@RequestMapping(method=RequestMethod.GET)
	public String rellenarFormulario(Model modelo){
		Tarea tarea  = new Tarea();
		modelo.addAttribute("agregar",tarea);
		return "nuevaTarea";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String procesaFormulario(@ModelAttribute("agregar") Tarea tarea, 
									BindingResult result, Model modelo){
		if(tarea.getNombre().length()==0){
			result.rejectValue("descripcion","longitud");
		}
		if(result.hasErrors()){
			return "nuevaTarea";
		}else{
			tareaBusiness.aniadirTarea(tarea);
			return "redirect:principal.do";
		}
		
	}
	
}
