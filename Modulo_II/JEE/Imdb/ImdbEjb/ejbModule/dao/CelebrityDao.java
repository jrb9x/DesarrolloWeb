package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import beans.Celebrity;

/**
 * Session Bean implementation class CelebrityDao
 */
@Stateless
@LocalBean
public class CelebrityDao implements CelebrityDaoRemote, CelebrityDaoLocal {

	@PersistenceContext(unitName="Imdb")
	EntityManager entityManager;

    @SuppressWarnings("unchecked")
	public ArrayList<Celebrity> selectCelebrity() {
       String prepareQuery = "select celebrity from Celebrity celebrity";
       Query query = entityManager.createQuery(prepareQuery);
       ArrayList<Celebrity> resultList = (ArrayList<Celebrity>) query.getResultList();
       return resultList;
   }
   
   @SuppressWarnings("unchecked")
public Celebrity selectPeliculaPorId(int idCelebrity) {
	   
	   Integer idInteger = (Integer)idCelebrity;
       String prepareQuery = "select celebrity from Celebrity celebrity where id = :id";
       Query query = entityManager.createQuery(prepareQuery);
       query.setParameter("id", idInteger);
       List<Celebrity> results = query.getResultList();
       if(!results.isEmpty()){
       	return results.get(0);
       }
       return null;
   }
   
   @SuppressWarnings("unchecked")
public ArrayList<Celebrity> buscarCelebritys(String buscar) {
	   
       String prepareQuery = "select c from Celebrity c "
       		+ "where ((c.nombre LIKE '"+buscar+"%') OR (c.nombre LIKE '%"+buscar+"%') OR (c.nombre LIKE '%"+buscar+"'))"
       		+ "OR ((c.apellidos LIKE '"+buscar+"%') OR (c.apellidos LIKE '%"+buscar+"%') OR (c.apellidos LIKE '%"+buscar+"'))";
       Query query = entityManager.createQuery(prepareQuery);
       ArrayList<Celebrity> listaCelebritys = (ArrayList<Celebrity>) query.getResultList();
       return listaCelebritys;
   }

   	public boolean insertCelebrity(Celebrity celebrity) {
   		
		entityManager.persist(celebrity);
		
		return true;
	}
   
   	public boolean updateCelebrity(Celebrity c) {
	   
		/*Celebrity celebrity = entityManager.find(Celebrity.class, c.getId());
		celebrity.setNombre(c.getNombre());
		celebrity.setApellidos(c.getApellidos());
		celebrity.setNacionalidad(c.getNacionalidad());
		celebrity.setFechaNacimiento(c.getFechaNacimiento());
		celebrity.setRutaFoto(c.getRutaFoto());
		celebrity.setListaPeliculas(c.getListaPeliculas());
		celebrity.setActor(c.isActor());
		celebrity.setDirector(c.isDirector());
		entityManager.flush();*/
		entityManager.merge(c);
		
		return true;
	}
   
   	public boolean deleteCelebrity(int idCelebrity) {
	  
       Integer idInteger = (Integer)idCelebrity;
       Celebrity celebrity = entityManager.find(Celebrity.class, idInteger);

       entityManager.remove(celebrity);
	   
       return true;
   	}

	@SuppressWarnings("unchecked")
	public ArrayList<Celebrity> buscarCelebritysDirectores() {
		String prepareQuery = "select celebrity from Celebrity celebrity";
	    Query query = entityManager.createQuery(prepareQuery);
	    ArrayList<Celebrity> listaCelebritys = (ArrayList<Celebrity>) query.getResultList();
	    ArrayList<Celebrity> aux = new ArrayList<Celebrity>();
	    for (Celebrity celebrity : listaCelebritys) {
			if(celebrity.isDirector()){
				aux.add(celebrity);
			}
		}
	    return aux;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Celebrity> buscarCelebritysActores() {
		String prepareQuery = "select celebrity from Celebrity celebrity";
	    Query query = entityManager.createQuery(prepareQuery);
	    ArrayList<Celebrity> listaCelebritys = (ArrayList<Celebrity>) query.getResultList();
	    ArrayList<Celebrity> aux = new ArrayList<Celebrity>();
	    for (Celebrity celebrity : listaCelebritys) {
			if(celebrity.isActor()){
				aux.add(celebrity);
			}
		}
	    return aux;
	}
}
