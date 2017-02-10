package negocio;

import java.util.ArrayList;

import javax.ejb.Remote;

import beans.Pelicula;

@Remote
public interface GestionPeliculaRemote {

	public boolean aniadirPelicula(Pelicula pelicula);
    public boolean borrarPelicula(int idPelicula);
    public boolean modificarPelicula(Pelicula pelicula);
    public ArrayList<Pelicula> listarPeliculas();
    public Pelicula listarPeliculasId(int idPelicula);
    public ArrayList<Pelicula> listarPeliculasBuscada(String buscar);
}
