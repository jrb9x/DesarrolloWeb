package business;

import beans.Usuario;
import dao.IUsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jorge on 01/02/2017.
 */
@Service
@Transactional
public class UsuarioBusiness implements IUsuarioBusiness {

    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    public boolean validarUsuario(Usuario usuario) {
        Usuario usuarioEncontrado = usuarioDao.selectUsuario(usuario.getNombre());
        if(usuario.getNombre().equals(usuarioEncontrado.getNombre()) &&
                usuario.getPassword().equals(usuarioEncontrado.getPassword()))
            return true;
        else
            return false;
    }

    @Override
    public boolean registrarUsuario(Usuario usuario) {
        return usuarioDao.insertUsuario(usuario);
    }
}
