package com.dao;

import com.beans.Usuario;

public interface UsuarioDao {

	public Usuario selectUsuario(String nombre);
	public boolean insertUsuario(Usuario usuario);

}
