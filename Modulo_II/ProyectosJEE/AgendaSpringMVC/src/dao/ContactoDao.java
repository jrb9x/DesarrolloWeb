package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import beans.Contacto;
import beans.Usuario;

@Repository
public class ContactoDao implements IContactoDao{

	@PersistenceContext
	EntityManager em;

	public boolean guardarContacto(Contacto contacto, Usuario usuario) {

		em.persist(contacto);
			
		List<Contacto> contactoList = ListarContactosDe(usuario);

		contactoList.add(contacto);
			
		usuario.setContacto(contactoList);
			
		em.merge(usuario);

        return true;
    }
	
	public Contacto recuperarPersona(Integer id) {
		
		Contacto contacto = em.find(Contacto.class, id);
		
        return contacto;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Contacto> ListarContactosDe(Usuario usuario) {
		
		String jpql = "SELECT u.contacto FROM Usuario u WHERE u.nombre = ?1";
		Query query = em.createQuery(jpql);
		query.setParameter(1, usuario.getNombre());
		
		ArrayList<Contacto> resultados = (ArrayList<Contacto>) query.getResultList();
        
        return resultados;
		
	}
	
	public boolean borrarContacto(Integer id){
		
        Contacto contacto = em.find(Contacto.class, id);
    
        em.remove(contacto);
        
        return true;

	}

	@Override
	public boolean actualizarContacto(Contacto contacto) {
        
        em.merge(contacto);

        return true;
	}
}
