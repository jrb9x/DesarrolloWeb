package negocio;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.Celebrity;
import dao.CelebrityDao;

/**
 * Session Bean implementation class GestionCelebrity
 */
@Stateless
@LocalBean
public class GestionCelebrity implements GestionCelebrityRemote, GestionCelebrityLocal {

	@EJB
	private CelebrityDao celebrityDao;
    
    public boolean aniadirCelebrity(Celebrity celebrity){
    	return celebrityDao.insertCelebrity(celebrity);
    }
    

	public boolean modificarCelebrity(Celebrity celebrity){
    	boolean ok = celebrityDao.updateCelebrity(celebrity);
    	if(ok == true){
    		return ok;
    	}
    	return false;
    }
	
	public ArrayList<Celebrity> listarCelebritys(){
	    return celebrityDao.selectCelebrity();
	}
	
	public Celebrity listarCelebrityId(int idCelebrity){
	    return celebrityDao.selectPeliculaPorId(idCelebrity);
	}
	
	public ArrayList<Celebrity> listarCelebrityBuscada(String buscar){
	    return celebrityDao.buscarCelebritys(buscar);
	}
	
	public ArrayList<Celebrity> listarCelebrityDirectores(){
	    return celebrityDao.buscarCelebritysDirectores();
	} 
	
	public ArrayList<Celebrity> listarCelebrityActores(){
	    return celebrityDao.buscarCelebritysActores();
	} 

}
