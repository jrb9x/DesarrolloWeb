package com.controlador;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.beans.Usuario;
import com.negocio.GestionUsuarios;

@WebServlet("/ServletRegistro")
public class ServletRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GestionUsuarios gestionUsuarios;
	
    public ServletRegistro() {
        super();
        gestionUsuarios = new GestionUsuarios();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		ServletContext sc = getServletContext();
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sc);
    	Usuario usuario = new Usuario(nombre,password);

		if(gestionUsuarios.registrarUsuario(usuario)){
			response.sendRedirect("index.jsp?msg="+ nombre +" registrado");
		}else{
			response.sendRedirect("index.jsp?msg=Fallo en el registro");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
