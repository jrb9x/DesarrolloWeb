package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beans.Usuario;
import business.IUsuarioBusiness;

@Controller
@RequestMapping("/login.do")

public class LoginController {

	@Autowired
    private IUsuarioBusiness usuarioBusiness;
	
	@RequestMapping(method = RequestMethod.GET)
    public String procesar(Model modelo){
    	Usuario usuario = new Usuario();
    	modelo.addAttribute("usuario", usuario);
    	return "login";
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public String procesarFormulario(@ModelAttribute("usuario") Usuario usuario,
    		HttpServletRequest req,
			BindingResult result){
		
		if(usuario.getNombre().length() == 0)
			result.rejectValue("nombre", "longitud");
		
    	if(usuario.getPassword().length() == 0)
			result.rejectValue("password", "longitud");
    	
		if(result.hasErrors())
			return "index";
		
		if(usuarioBusiness.validarUsuario(usuario)){
			HttpSession session = req.getSession(true);
			session.setAttribute("usuario", usuario);
			
			
			//return "redirect:principal.do";
			return "logado";
		}else{
			return "redirect:login.do";
		}
		
	}
}
