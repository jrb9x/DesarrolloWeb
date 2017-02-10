package controlador;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Pelicula;
import beans.Usuario;
import negocio.GestionPeliculaRemote;

@WebServlet("/ServletMostrarPeliculas")
public class ServletMostrarPeliculas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private GestionPeliculaRemote gestionPeliculas;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession(false);
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		String id = request.getParameter("idMostrar");
		
		if(id != null){
			Pelicula pelicula = gestionPeliculas.listarPeliculasId(new Integer(id));
			session.setAttribute("pelicula", pelicula);
			response.sendRedirect("mostrarPelicula.jsp");		
		}else{
			List<Pelicula> listaPeliculas = null;
			listaPeliculas = gestionPeliculas.listarPeliculas();	
			session.setAttribute("listaPeliculas",listaPeliculas);
			response.sendRedirect("mostrarTodasPeliculas.jsp");				
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
