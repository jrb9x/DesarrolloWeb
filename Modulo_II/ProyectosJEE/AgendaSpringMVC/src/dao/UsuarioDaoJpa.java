package dao;

import beans.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by jorge on 01/02/2017.
 */
@Repository
public class UsuarioDaoJpa implements IUsuarioDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public Usuario selectUsuario(String nombre){
        Usuario usuario = em.find(Usuario.class, nombre);

        return usuario;
    }

    @Override
    public boolean insertUsuario(Usuario usuario) {
        em.persist(usuario);

        return true;
    }
}
