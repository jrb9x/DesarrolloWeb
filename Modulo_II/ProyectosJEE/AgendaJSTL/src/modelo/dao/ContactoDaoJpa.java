package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import beans.Contacto;
import beans.Usuario;

public class ContactoDaoJpa implements ContactoDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendaJSTL");
	EntityManager em = emf.createEntityManager();

	public boolean guardarContacto(Contacto contacto, Usuario usuario) {

		boolean success = false;
		
		EntityTransaction tx = em.getTransaction();

		try{
			tx.begin();
			em.persist(contacto);
			
			List<Contacto> contactoList = new ArrayList<Contacto>();
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
	
	public Contacto recuperarPersona(int id) {
		Contacto contacto = null;
		/*
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM contactos WHERE id_persona="+ id );
			
			while (rs.next()) {
				String nombre = rs.getString("nombre");
		    	String apellidos = rs.getString("apellidos");
		    	String dni = rs.getString("dni");
		    	String telefono = rs.getString("telefono");
		    	Fecha fecha = new Fecha(rs.getString("fecha"));
		    	 
		    	contacto = new Contacto(id ,nombre, apellidos, dni,telefono, fecha);
		    	return contacto;
			}
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		return contacto;
	}
	
	public ArrayList<Contacto> ListarContactosDe(Usuario usuario) {
		
		String jpql = "SELECT u.contacto FROM Usuario u WHERE u.nombre = ?1";
		Query query = em.createQuery(jpql);
		query.setParameter(1, usuario.getNombre());
		
		ArrayList<Contacto> resultados = (ArrayList<Contacto>) query.getResultList();
        
        return resultados;
		
	}
	
	public boolean borrarContacto(int id){
		return false;

	}
	
}
