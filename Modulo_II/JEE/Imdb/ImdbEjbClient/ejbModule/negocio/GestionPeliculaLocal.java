package negocio;

import java.util.ArrayList;

import javax.ejb.Local;

import beans.Pelicula;

@Local
public interface GestionPeliculaLocal {

	public boolean aniadirPelicula(Pelicula pelicula);
    public boolean borrarPelicula(int idPelicula);
    public boolean modificarPelicula(Pelicula pelicula);
    public ArrayList<Pelicula> listarPeliculas();
    public Pelicula listarPeliculasId(int idPelicula);
    public ArrayList<Pelicula> listarPeliculasBuscada(String buscar);
}
