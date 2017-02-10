package controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Celebrity;
import beans.Pelicula;
import beans.Usuario;
import negocio.GestionCelebrityRemote;
import negocio.GestionPeliculaRemote;

@WebServlet("/ServletGuardarPelicula")
public class ServletGuardarPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private GestionPeliculaRemote gestionPeliculas;
	private GestionCelebrityRemote gestionCelebritys;
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession(false);
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		Pelicula peliculaGestionada = (Pelicula) session.getAttribute("peliculaGestionada");
		
		String titulo = request.getParameter("titulo");
		LocalDate fechaEstreno = LocalDate.parse(request.getParameter("fechaEstreno"));
		int duracion = Integer.parseInt(request.getParameter("duracion"));
		String genero = request.getParameter("genero");
		String pais = request.getParameter("pais");
		String sinopsis = request.getParameter("sinopsis");
		String rutaFoto = request.getParameter("rutaFoto");
		String director = request.getParameter("director");
		List<Celebrity> listaCelebritys = (List<Celebrity>) peliculaGestionada.getListaCelebritys();
		
		
		/*for (Celebrity celebrity : listaCelebritys) {
			List<Pelicula> listaPeliculas = celebrity.getListaPeliculas();
			listaPeliculas.add(peliculaGestionada);
			celebrity.setListaPeliculas(listaPeliculas);
			//gestionCelebritys.modificarCelebrity(celebrity);
		}*/

		
		Pelicula peliculaNueva = new Pelicula(titulo, fechaEstreno, duracion, genero, pais, sinopsis, director, listaCelebritys, rutaFoto);
		gestionPeliculas.aniadirPelicula(peliculaNueva);
		
		response.sendRedirect("ServletPrincipal");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
