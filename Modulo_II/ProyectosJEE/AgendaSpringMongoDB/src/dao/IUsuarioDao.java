package dao;

import beans.Usuario;
import org.springframework.stereotype.Repository;

/**
 * Created by jorge on 01/02/2017.
 */
@Repository
public interface IUsuarioDao {
    Usuario selectUsuario(String nombre);
    boolean insertUsuario(Usuario usuario);
}
