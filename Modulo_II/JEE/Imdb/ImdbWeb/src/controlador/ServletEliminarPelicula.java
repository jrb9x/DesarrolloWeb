package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.GestionPeliculaRemote;


@WebServlet("/ServletEliminarPelicula")
public class ServletEliminarPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private GestionPeliculaRemote gestionPeliculas;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = new Integer(request.getParameter("idEliminar"));
		gestionPeliculas.borrarPelicula(id);
		response.sendRedirect("ServletPrincipal");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
