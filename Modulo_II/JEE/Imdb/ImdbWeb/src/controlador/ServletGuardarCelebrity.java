package controlador;

import java.io.IOException;
import java.time.LocalDate;
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
import negocio.GestionCelebrityRemote;


@WebServlet("/ServletGuardarCelebrity")
public class ServletGuardarCelebrity extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private GestionCelebrityRemote gestionCelebritys;	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession(false);
		String id = request.getParameter("id");
		String tipo = request.getParameter("tipo");
		Pelicula peliculaGestionada = (Pelicula) session.getAttribute("peliculaGestionada");
		
		if(id!=null){
			Celebrity celebrity = gestionCelebritys.listarCelebrityId(new Integer(id));
			celebrity.setId(new Integer(id));
			if(tipo.equals("director")){
				peliculaGestionada.setDirector(celebrity.getNombre()+" "+celebrity.getApellidos());
				celebrity.setDirector(true);
			}else{
				if(tipo.equals("actor")){
					celebrity.setActor(true);
				}
			}
			System.out.println(celebrity.toString());
			gestionCelebritys.modificarCelebrity(celebrity);
			Celebrity aux = gestionCelebritys.listarCelebrityId(new Integer(id));
			if(!peliculaGestionada.getListaCelebritys().contains(aux)){
				peliculaGestionada.getListaCelebritys().add(aux);
			}
			//session.setAttribute("listaBuscada", new ArrayList<Celebrity>());
		}else{
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			String nacionalidad = request.getParameter("nacionalidad");
			String fecha = request.getParameter("fechaNacimiento");
			LocalDate fechaNacimiento = LocalDate.parse(fecha);
			boolean actor=false,director=false;
			if(tipo.equals("director")){
				director=true;
			}else if(tipo.equals("actor")){
				actor=true;
			}
			String rutaFoto = request.getParameter("rutaFoto");
			List<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
			Celebrity celebrity = new Celebrity(nombre, apellidos, nacionalidad, fechaNacimiento, actor, director, listaPeliculas, rutaFoto);
			gestionCelebritys.aniadirCelebrity(celebrity);
			peliculaGestionada.getListaCelebritys().add(celebrity);
			
		}
		session.setAttribute("peliculaGestionada", peliculaGestionada);
		response.sendRedirect("gestionarPelicula.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
