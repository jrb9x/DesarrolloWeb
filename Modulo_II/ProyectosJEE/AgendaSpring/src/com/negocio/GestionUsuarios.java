package com.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beans.Usuario;
import com.dao.UsuarioDao;

@Service
@Transactional
public class GestionUsuarios {

	@Autowired
	UsuarioDao usuarioDao;
	
	public boolean validarUsuario(Usuario usuario){
		Usuario usuarioEncontrado = usuarioDao.selectUsuario(usuario.getNombre());
		
		if(usuario != null && usuario.getNombre().equals(usuarioEncontrado.getNombre()) && usuario.getPassword().equals(usuarioEncontrado.getPassword()))
			return true;
		else
			return false;
	}
	
	public boolean registrarUsuario(Usuario usuario){
		if (usuario != null) {
			usuarioDao.insertUsuario(usuario);
			return true;
		}
		return false;
	}
}
