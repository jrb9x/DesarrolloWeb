package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/logout.do")
public class LogoutController {
	
	@RequestMapping(method = RequestMethod.GET)
    public String procesarFormulario(HttpSession sesion) {
		sesion.invalidate();
		
		return "redirect:login.do";
	}
	
}
