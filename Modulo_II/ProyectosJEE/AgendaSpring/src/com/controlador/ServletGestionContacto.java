package com.controlador;

import java.io.IOException;

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

@WebServlet("/ServletGestionContacto")
public class ServletGestionContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Agenda agenda;

    public ServletGestionContacto() {
        super();
        agenda= new Agenda();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		String idModificar = request.getParameter("idModificar");
		
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Contacto contacto = (Contacto)ac.getBean(Contacto.class);
		
		if (idModificar != null) {
			contacto = agenda.buscarPersonaPorId(new Integer(idModificar));
			
			session.setAttribute("contactoModificar", contacto);
			
	        response.sendRedirect("formularioContacto.jsp");
		}else{
		session.setAttribute("contactoModificar", contacto);
		response.sendRedirect("formularioContacto.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
