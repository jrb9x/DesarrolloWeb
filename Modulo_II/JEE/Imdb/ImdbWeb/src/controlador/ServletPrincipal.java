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


@WebServlet("/ServletPrincipal")
public class ServletPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private GestionPeliculaRemote gestionPeliculas;
	private GestionCelebrityRemote gestionCelebritys;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession(true);			
		
		ArrayList<Pelicula> listaPeliculas = gestionPeliculas.listarPeliculas();
		session.setAttribute("listaPeliculas", listaPeliculas);
		ArrayList<Celebrity> listaCelebritys = gestionCelebritys.listarCelebritys();
		session.setAttribute("listaCelebritys", listaCelebritys);
		response.sendRedirect("principal.jsp");
		//response.sendRedirect("ServletGestionarPelicula");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
