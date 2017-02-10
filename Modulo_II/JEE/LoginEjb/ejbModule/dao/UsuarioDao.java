package dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import beans.Usuario;


/**
 * Session Bean implementation class UsuarioDao
 */
@Stateless
@LocalBean
public class UsuarioDao implements UsuarioDaoRemote, UsuarioDaoLocal {

	@PersistenceContext(unitName="Login")
    private EntityManager entityManager;

	@Override
	public Usuario selectUsuario(String nombre) {
		
		String prepareQuery = "select usuario from Usuario usuario where usuario.nombre = :nombre";
        
		Query query = entityManager.createQuery(prepareQuery);
        query.setParameter("nombre", nombre);
        
        Usuario usuario = (Usuario) query.getSingleResult();
        
		return usuario;
	}

	@Override
	public boolean deleteUsuario(int idUsuario) {
		
		Integer idInteger = (Integer) idUsuario;
		
		Usuario usuario = entityManager.find(Usuario.class, idInteger);

		entityManager.remove(usuario);
		
		return true;
	}

	@Override
	public boolean insertUsuario(Usuario usuario) {

		entityManager.persist(usuario);
		
		return true;
	}

}
