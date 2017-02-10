package modelo.dao;

import javax.persistence.*;

import beans.Usuario;

public class UsuarioDAOJpa implements UsuarioDAO{

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendaJSTL");
	EntityManager em = emf.createEntityManager();

	public Usuario recuperarUsuario(String nombre){
		Usuario usuario = em.find(Usuario.class, nombre);
		
		return usuario;
	}

	public boolean registrarUsuario(Usuario usuario) {
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

	public void cerrarConexion(){
		em.close();
		emf.close();
	}

}
