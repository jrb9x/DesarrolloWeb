package com.controlador;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Contacto;
import com.beans.Usuario;
import com.negocio.Agenda;


@WebServlet("/ServletGuardarContacto")
public class ServletGuardarContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Agenda agenda;

    public ServletGuardarContacto() {
    	super();
    	agenda= new Agenda();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Contacto contacto = (Contacto)ac.getBean(Contacto.class);
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		String id = (String) request.getParameter("id");
		
		contacto.setNombre(request.getParameter("nombre"));
		contacto.setApellidos(request.getParameter("apellidos"));
		contacto.setDni(request.getParameter("dni"));
		contacto.setTelefono(request.getParameter("telefono"));
		LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
		contacto.setFecha(fecha);
		
		if(id.equals("null")){
			contacto.setId(null);
			agenda.aniadirPersona(contacto, usuario);
		}else{
			contacto.setId(Integer.parseInt(id));
			agenda.modificarContacto(contacto);
		}
		
		response.sendRedirect("ServletPrincipal");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
