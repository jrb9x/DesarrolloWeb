package modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import beans.Usuario;

public class UsuarioDaoJpa implements UsuarioDao{
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendaJpa");
	EntityManager em = emf.createEntityManager();
	
	@Override
	public Usuario selectUsuario(String nombre) {
		Usuario usuario = em.find(Usuario.class, nombre);
		
		return usuario;
	}

	@Override
	public boolean insertUsuario(Usuario usuario)  {
		boolean success;
		EntityTransaction tx = em.getTransaction();

		try{
			tx.begin();
			em.persist(usuario);
			tx.commit();
			success = true;
		}catch (Exception e) {
			tx.rollback();
			success = false;
		}

		return success;
	}

	@Override
	public void cerrarConexion(){
		em.close();
		emf.close();
	}

}
