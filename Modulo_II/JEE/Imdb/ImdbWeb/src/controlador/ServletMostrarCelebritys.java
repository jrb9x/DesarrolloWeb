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

import beans.Celebrity;
import negocio.GestionCelebrityRemote;


@WebServlet("/ServletMostrarCelebritys")
public class ServletMostrarCelebritys extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private GestionCelebrityRemote gestionCelebritys;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession(false);
		String id = request.getParameter("idMostrar");
		if(id != null){
			Celebrity celebrity = gestionCelebritys.listarCelebrityId(new Integer(id));
			session.setAttribute("celebrity", celebrity);
			response.sendRedirect("mostrarCelebrity.jsp");		
		}else{
			List<Celebrity> listaCelebritys = gestionCelebritys.listarCelebritys();
			session.setAttribute("listaCelebritys",listaCelebritys);
			response.sendRedirect("mostrarTodasCelebritys.jsp");				
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
