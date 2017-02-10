package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.beans.Usuario;

@Repository
public class UsuarioDaoJpa implements UsuarioDao{
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Usuario selectUsuario(String nombre) {
		Usuario usuario = em.find(Usuario.class, nombre);
		
		return usuario;
	}

	@Override
	public boolean insertUsuario(Usuario usuario)  {
		
		em.persist(usuario);
		
		return true;
	}

}
