package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Celebrity;
import beans.Pelicula;
import negocio.GestionCelebrityRemote;
import negocio.GestionPeliculaRemote;

@WebServlet("/ServletBuscar")
public class ServletBuscar extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@EJB
	private GestionCelebrityRemote gestionCelebritys;
	private GestionPeliculaRemote gestionPeliculas;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession(false);
		String buscar = request.getParameter("texto");
		
		ArrayList<Pelicula> listaPeliculaBuscada = gestionPeliculas.listarPeliculasBuscada(buscar);
		ArrayList<Celebrity> listaCelebrityBuscada = gestionCelebritys.listarCelebrityBuscada(buscar);
		session.setAttribute("listaPeliculaBuscada", listaPeliculaBuscada);
		session.setAttribute("listaCelebrityBuscada", listaCelebrityBuscada);
		response.sendRedirect("mostrarBusqueda.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
