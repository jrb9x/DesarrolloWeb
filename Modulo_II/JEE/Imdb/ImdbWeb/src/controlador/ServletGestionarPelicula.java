package controlador;

import java.io.IOException;
import java.util.ArrayList;
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
import negocio.GestionPeliculaRemote;


@WebServlet("/ServletGestionarPelicula")
public class ServletGestionarPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private GestionPeliculaRemote gestionPeliculas;	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession(false);
		
		String id = request.getParameter("idModificar");
		String titulo="";
		int duracion=0;
		String genero="";
		String pais="";
		String sinopsis="";
		String director="";
		String rutaFoto="";
		List<Celebrity> listaCelebritys = new ArrayList<Celebrity>();
		Pelicula peliculaGestionada = new Pelicula(titulo, null, duracion, genero, pais, sinopsis, director, listaCelebritys, rutaFoto);
		
		if(id!=null){
			peliculaGestionada = gestionPeliculas.listarPeliculasId(new Integer(id));
		}
		
		session.setAttribute("peliculaGestionada", peliculaGestionada);
		//session.setAttribute("listaCelebritysAgregadas", new ArrayList<Celebrity>());
		request.getRequestDispatcher("gestionarPelicula.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}
}
