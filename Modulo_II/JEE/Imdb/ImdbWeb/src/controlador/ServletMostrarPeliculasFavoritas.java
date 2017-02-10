package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Pelicula;
import beans.Usuario;

@WebServlet("/ServletMostrarPeliculasFavoritas")
public class ServletMostrarPeliculasFavoritas extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession(false);
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		
		List<Pelicula> listaPeliculas = (List<Pelicula>) usuario.getListaPeliculasFavoritas();	
		session.setAttribute("listaPeliculas",listaPeliculas);
		response.sendRedirect("mostrarTodasPeliculas.jsp");				
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
