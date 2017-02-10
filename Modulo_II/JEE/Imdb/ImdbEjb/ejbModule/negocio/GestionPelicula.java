package negocio;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.Pelicula;
import dao.PeliculaDao;

/**
 * Session Bean implementation class GestionPelicula
 */
@Stateless
@LocalBean
public class GestionPelicula implements GestionPeliculaRemote, GestionPeliculaLocal {

	@EJB
	private PeliculaDao peliculaDao;
    
    public boolean aniadirPelicula(Pelicula pelicula){
    	return peliculaDao.insertPelicula(pelicula);
    }
    
    public boolean borrarPelicula(int idPelicula){
    	boolean ok = peliculaDao.deletePelicula(idPelicula);
    	if(ok == true){
    		return true;
    	}
    	return false;
    }
    
    public boolean modificarPelicula(Pelicula pelicula){
    	boolean ok = peliculaDao.updatePelicula(pelicula);
    	if(ok == true){
    		return true;
    	}
    	return false;
    }
    
    public ArrayList<Pelicula> listarPeliculas(){
    	return peliculaDao.selectPelicula();
    }
    
    public Pelicula listarPeliculasId(int idPelicula){
    	return peliculaDao.selectPeliculaPorId(idPelicula);
    }
    
    public ArrayList<Pelicula> listarPeliculasBuscada(String buscar){
    	return peliculaDao.buscarPeliculas(buscar);
    }

}
