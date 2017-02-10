package com.negocio;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beans.Contacto;
import com.beans.Usuario;
import com.dao.ContactoDao;

@Service
@Transactional
public class Agenda {

	@Autowired
	private ContactoDao contactoDao;
	
	public boolean aniadirPersona(Contacto contacto, Usuario usuario){
		boolean aniadido = contactoDao.guardarContacto(contacto, usuario);

		return aniadido;
	}
	
	public boolean borrarPersonaPorId(Usuario usuario,Integer id){
		boolean borrado = contactoDao.borrarContacto(usuario,id);

		return borrado;
	}
	
	public ArrayList<Contacto> recuperarAgenda(Usuario usuario){
		ArrayList<Contacto> lista = contactoDao.ListarContactosDe(usuario);
		return lista;
	}
	
	public Contacto buscarPersonaPorId(Integer id){
		return contactoDao.recuperarPersona(id);
	}
	
	public ArrayList<Contacto> recuperarCumplenEnDe(String mes, Usuario usuario){
		ArrayList<Contacto> contactos = contactoDao.ListarContactosDe(usuario);
		ArrayList<Contacto> contactosAux = new ArrayList<Contacto>();
		int mesInt = Integer.parseInt(mes);
		
		for (Contacto persona : contactos) {
			if(mesInt == persona.getFecha().getMonthValue()){
				contactosAux.add(persona);
			}
		}
		return contactosAux;
	}
	
	public boolean modificarContacto(Contacto contacto){
		boolean modificado = contactoDao.actualizarContacto(contacto);

		return modificado;
	}

}