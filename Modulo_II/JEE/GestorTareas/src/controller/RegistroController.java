package controller;

import beans.Usuario;
import model.business.IUsuarioBusiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jorge on 01/02/2017.
 */
@Controller
@RequestMapping("/registro.do")
public class RegistroController {

    @Autowired
    private IUsuarioBusiness usuarioBusiness;
    
    @RequestMapping(method = RequestMethod.GET)
    public String procesar(Model modelo){
    	Usuario usuario = new Usuario();
    	modelo.addAttribute("usuario", usuario);
    	return "formularioUsuario";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String procesarFormulario(@ModelAttribute("usuario") Usuario usuario,
			BindingResult result,
			Model modelo){
    	
    	if(usuario.getNombre().length() == 0)
			result.rejectValue("nombre", "longitud");
		
    	if(usuario.getPassword().length() == 0)
			result.rejectValue("password", "longitud");
    	
		if(result.hasErrors())
			return "formularioUsuario";
		
        usuarioBusiness.registrarUsuario(usuario);

        return "index";
    }


}
