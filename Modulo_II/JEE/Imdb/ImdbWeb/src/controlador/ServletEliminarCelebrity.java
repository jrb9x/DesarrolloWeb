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


@WebServlet("/ServletEliminarCelebrity")
public class ServletEliminarCelebrity extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private GestionCelebrityRemote gestionCelebritys;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession(false);
		int id = new Integer(request.getParameter("idEliminar"));
		
		Pelicula peliculaGestionada = (Pelicula) session.getAttribute("peliculaGestionada");
		ArrayList<Celebrity> listaCelebritys = (ArrayList<Celebrity>) peliculaGestionada.getListaCelebritys();
		int pos=-1;
		for (int i=0;i<listaCelebritys.size();i++) {
			System.out.println(listaCelebritys.get(i).toString());
		}
		
		for (int i=0;i<listaCelebritys.size();i++) {
			if(listaCelebritys.get(i).getId().equals(id)){
				pos = i; 
			}
		}
		listaCelebritys.remove(pos);
		peliculaGestionada.setListaCelebritys(listaCelebritys);
		session.setAttribute("peliculaGestionada", peliculaGestionada);
		response.sendRedirect("gestionarPelicula.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
