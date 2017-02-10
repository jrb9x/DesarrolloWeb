package controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import beans.BusquedaOferta;
import beans.Oferta;
import modelo.negocio.IGestionOfertas;

@Controller
@RequestMapping("/ofertas.do")
public class ControladorOfertas {

	@Autowired
	IGestionOfertas gestionOfertas;
	
	@RequestMapping(method=RequestMethod.GET)
	public String procesar(
			@RequestParam(value="precio", required=false, defaultValue="0.0") double precio,
			Model modelo){
		List<Oferta> ofertas;
		
		ofertas = gestionOfertas.buscarOfertasPorPrecio(precio);
		modelo.addAttribute("ofertas", ofertas);
		
		return "vistaOfertas";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String procesarFormulario(BusquedaOferta busqueda, Model modelo){
		List<Oferta> ofertas;
		
		ofertas = gestionOfertas.buscarOfertasPorPrecioyNoches(busqueda);
		modelo.addAttribute("ofertas", ofertas);
		
		return "vistaOfertas";
	}
	
	/*
	public ModelAndView procesar(
			@RequestParam(value="precio", required=false, defaultValue="0.0") double precio){
		List<Oferta> ofertas;
		
		ofertas = gestionOfertas.buscarOfertasPorPrecio(precio);
		ModelMap modelo = new ModelMap();
		modelo.addAttribute("ofertas", ofertas);
		return new ModelAndView("vistaOfertas", modelo);
	}
	*/
}
