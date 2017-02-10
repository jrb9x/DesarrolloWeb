package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import beans.Pelicula;
import beans.Usuario;

/**
 * Session Bean implementation class UsuarioDao
 */
@Stateless
@LocalBean
public class UsuarioDao implements UsuarioDaoRemote, UsuarioDaoLocal {

	@PersistenceContext(unitName="Imdb")
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public Usuario selectUsuario(String nombre) {
		String prepareQuery = "select usuario from Usuario usuario where usuario.nombre=:nombre";
        
		Query query = entityManager.createQuery(prepareQuery);
        query.setParameter("nombre", nombre);
        
        List<Usuario> results = query.getResultList();
        if(!results.isEmpty()){
        	return results.get(0);
        }
		return null;
		
	}

	public boolean deleteUsuario(int idUsuario) {
		
		Integer idInteger = (Integer) idUsuario;
		
		Usuario usuario = entityManager.find(Usuario.class, idInteger);

		entityManager.remove(usuario);
		
		return true;
	}

	public boolean insertUsuario(Usuario usuario) {
		
		entityManager.persist(usuario);
		
		return true;
	}

	public boolean updateUsuario(Usuario user) {
		
		entityManager.merge(user);
		
		return true;
	}
	
	public boolean updateFavoritos(Pelicula pelicula, String nombre) {
		
		entityManager.merge(pelicula);
		
		return true;
	}

}