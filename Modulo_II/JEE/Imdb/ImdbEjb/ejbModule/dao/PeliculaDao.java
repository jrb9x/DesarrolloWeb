package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import beans.Pelicula;

/**
 * Session Bean implementation class PeliculaDao
 */
@Stateless
@LocalBean
public class PeliculaDao implements PeliculaDaoRemote, PeliculaDaoLocal {

	@PersistenceContext(unitName="Imdb")
	EntityManager entityManager;

   @SuppressWarnings("unchecked")
public ArrayList<Pelicula> selectPelicula() {
       String prepareQuery = "select pelicula from Pelicula pelicula";
       Query query = entityManager.createQuery(prepareQuery);
       ArrayList<Pelicula> resultList = (ArrayList<Pelicula>) query.getResultList();
       return resultList;
   }
   
   @SuppressWarnings("unchecked")
public Pelicula selectPeliculaPorId(int idPelicula) {
	   
	   Integer idInteger = (Integer)idPelicula;
       String prepareQuery = "select pelicula from Pelicula pelicula where id = :id";
       Query query = entityManager.createQuery(prepareQuery);
       query.setParameter("id", idInteger);
       List<Pelicula> results = query.getResultList();
       if(!results.isEmpty()){
       	return results.get(0);
       }
       return null;
   }
   
   	@SuppressWarnings("unchecked")
	public ArrayList<Pelicula> buscarPeliculas(String buscar) {
	   
       String prepareQuery = "select p from Pelicula p "
       		+ "where (p.titulo LIKE '"+buscar+"%') OR (p.titulo LIKE '%"+buscar+"%') OR (p.titulo LIKE '%"+buscar+"')";
       Query query = entityManager.createQuery(prepareQuery);
       ArrayList<Pelicula> listaPeliculas = (ArrayList<Pelicula>) query.getResultList();
       return listaPeliculas;
   	}

   	public boolean insertPelicula(Pelicula pelicula) {
   		
		entityManager.merge(pelicula);
		
		return true;
	}
   
   	public boolean updatePelicula(Pelicula p) {
   		
		Pelicula pelicula = entityManager.find(Pelicula.class, p.getId());
		pelicula.setTitulo(p.getTitulo());
		pelicula.setFechaEstreno(p.getFechaEstreno());
		pelicula.setDuracion(p.getDuracion());
		pelicula.setGenero(p.getGenero());
		pelicula.setPais(p.getPais());
		pelicula.setSinopsis(p.getSinopsis());
		pelicula.setRutaFoto(p.getRutaFoto());
		pelicula.setDirector(p.getDirector());
		pelicula.setListaCelebritys(p.getListaCelebritys());
		entityManager.flush();
		//entityManager.merge(p);
		
		return true;
	}
   
   	public boolean deletePelicula(int idPelicula) {
	  
		Integer idInteger = (Integer)idPelicula;
		Pelicula pelicula = entityManager.find(Pelicula.class, idInteger);

		entityManager.remove(pelicula);
		
       return true;
   }
}
