package controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beans.BusquedaOferta;
import beans.Oferta;
import modelo.negocio.IGestionOfertas;

@Controller
@RequestMapping("/busquedaOfertas.do")
public class BusquedaOfertas {

	@Autowired
	IGestionOfertas gestionOfertas;
	
	@RequestMapping(method=RequestMethod.GET)
	public String rellenaFormulario(Model modelo){
		BusquedaOferta bo = new BusquedaOferta();
		bo.setNumeroNoches(1);
		bo.setPrecioMax(60);
		modelo.addAttribute("bo", bo);
		
		return "busquedaOfertas";
	
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String procesaFormulario(@ModelAttribute("bo") BusquedaOferta bo,
			BindingResult result,
			Model modelo){
		
		if(bo.getPrecioMax() < 0)
			result.rejectValue("precioMax", "negativo");
		
		if(result.hasErrors())
			return "busquedaOfertas";
		
		List<Oferta> ofertas;
		ofertas = gestionOfertas.buscarOfertasPorPrecioyNoches(bo);
		
		modelo.addAttribute("ofertas", ofertas);
		
		return "vistaOfertas";
	}
}
