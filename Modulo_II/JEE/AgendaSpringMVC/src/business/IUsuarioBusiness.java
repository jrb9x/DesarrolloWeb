package business;

import beans.Usuario;
import org.springframework.stereotype.Service;

/**
 * Created by jorge on 01/02/2017.
 */
@Service
public interface IUsuarioBusiness {
    boolean validarUsuario(Usuario usuario);
    boolean registrarUsuario(Usuario usuario);
}
