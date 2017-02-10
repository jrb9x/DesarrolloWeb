package modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import beans.BusquedaOferta;
import beans.Oferta;

@Service
public class GestionOfertas implements IGestionOfertas {

	List<Oferta> ofertas;
	
	public GestionOfertas(){
		crearOfertas();
	}
	
	public void crearOfertas(){
		ofertas = new ArrayList<Oferta>();
		ofertas.add(new Oferta(50.5,1,"NH"));
		ofertas.add(new Oferta(150.5,2,"NH Madrid"));
		ofertas.add(new Oferta(300.8,2,"Palace"));
		ofertas.add(new Oferta(490,5,"Ritch"));
		ofertas.add(new Oferta(1550.6,7,"Gran Hotel"));
	}
	
	@Override
	public List<Oferta> buscarOfertasPorPrecio(double precioMax) {
		if(precioMax == 0)
			return ofertas;
		
		List<Oferta> aux = new ArrayList<Oferta>();
		for (Oferta oferta : ofertas) {
			if(oferta.getPrecio() < precioMax)
				aux.add(oferta);
		}
		
		return aux;
	}

	@Override
	public List<Oferta> todasLasOfertas() {

		return ofertas;
	}

	@Override
	public List<Oferta> buscarOfertasPorPrecioyNoches(BusquedaOferta busqueda) {
		List<Oferta> aux = new ArrayList<Oferta>();
		for (Oferta oferta : ofertas) {
			if(oferta.getPrecio() <= busqueda.getPrecioMax() &&
					oferta.getNumeroNoches() == busqueda.getNumeroNoches())
				aux.add(oferta);
		}
		
		return aux;
	}

	
}
