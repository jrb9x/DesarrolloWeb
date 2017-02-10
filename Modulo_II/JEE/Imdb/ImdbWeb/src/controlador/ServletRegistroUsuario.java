package controlador;

import java.io.IOException;
import java.util.*;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Pelicula;
import negocio.GestionUsuarioRemote;

@WebServlet("/ServletRegistroUsuario")
public class ServletRegistroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private GestionUsuarioRemote gestionUsuarios;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre= request.getParameter("nombre");
		String password= request.getParameter("password");
		System.out.println(nombre+"-"+password);
		List<Pelicula> listaPeliculasFavoritas = new ArrayList<Pelicula>();
		if(gestionUsuarios.aniadirUsuario(nombre, password, listaPeliculasFavoritas)){
			request.getRequestDispatcher("mensaje.jsp?head=Registro usuario&msg=Usuario registrado correctamente.").forward(request, response);			
		}else{
			request.getRequestDispatcher("/mensaje.jsp?head='Registro usuario'&msg='El usuario ya existe.'").forward(request, response);
				
		}
	}

}
