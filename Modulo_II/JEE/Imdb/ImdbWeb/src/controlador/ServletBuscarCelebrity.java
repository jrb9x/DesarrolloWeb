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
import negocio.GestionCelebrityRemote;

@WebServlet("/ServletBuscarCelebrity")
public class ServletBuscarCelebrity extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@EJB
	private GestionCelebrityRemote gestionCelebritys;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession(false);
		String buscar = request.getParameter("cadena");
		String tipo = request.getParameter("tipo");
		ArrayList<Celebrity> listaBuscada = gestionCelebritys.listarCelebrityBuscada(buscar);
		session.setAttribute("listaBuscada", listaBuscada);
		response.sendRedirect("gestionarCelebrity.jsp?tipo="+tipo);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
