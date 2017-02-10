package modelo.negocio;

import java.util.List;

import org.springframework.stereotype.Service;

import beans.BusquedaOferta;
import beans.Oferta;

@Service
public interface IGestionOfertas {

	public List<Oferta> buscarOfertasPorPrecio(double precioMax);
	public List<Oferta> todasLasOfertas();
	public List<Oferta> buscarOfertasPorPrecioyNoches(BusquedaOferta busqueda);
}
