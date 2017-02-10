package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import beans.Contacto;
import beans.Usuario;

public class ContactoDaoJpa implements ContactoDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendaJpa");
	EntityManager em = emf.createEntityManager();

	public boolean guardarContacto(Contacto contacto, Usuario usuario) {

		boolean success = false;
		
		EntityTransaction tx = em.getTransaction();

		try{
			tx.begin();
			em.persist(contacto);
			
			List<Contacto> contactoList = ListarContactosDe(usuario);

			contactoList.add(contacto);
			
			usuario.setContacto(contactoList);
			
			em.merge(usuario);
			
			tx.commit();
			success = true;
		}catch (Exception e) {
			tx.rollback();
			success = false;
		}

        return success;
    }
	
	public Contacto recuperarPersona(Integer id) {
		
        String prepareQuery = "select contacto from Contacto contacto where id = :id";
        Query query = em.createQuery(prepareQuery);
        query.setParameter("id", id);
        
        Contacto contacto = (Contacto) query.getSingleResult();
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
	
	public boolean borrarContacto(Usuario usuario, Integer id){
		EntityTransaction transaction = em.getTransaction();
        Contacto contacto = em.find(Contacto.class, id);
        
        
        transaction.begin();
        
        em.remove(contacto);
        
        transaction.commit();
        return true;

	}

	@Override
	public boolean actualizarContacto(Contacto contacto) {
		EntityTransaction transaction = em.getTransaction();
        
        transaction.begin();
        
        em.merge(contacto);
        
        transaction.commit();
        return true;
	}
	
}
