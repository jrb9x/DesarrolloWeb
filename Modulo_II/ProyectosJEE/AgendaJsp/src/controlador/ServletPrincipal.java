package controlador;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Persona;
import modelo.Agenda;


/**
 * Servlet implementation class HolaDinamico
 */
@WebServlet("/ServletPrincipal")
public class ServletPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Agenda agenda;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPrincipal() {
        super();
        agenda = new Agenda();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession(false);
		
		ArrayList<Persona> contactos;

		if(session==null){
			response.sendRedirect("/index.jsp");
		}else {
			String nombreUsuario = (String) session.getAttribute("login");
			
			String mes = request.getParameter("mes");
            if(mes == null){
            contactos = agenda.recuperarAgenda(nombreUsuario);
            }
            else{
            contactos = agenda.recuperarCumplenEnDe(mes, nombreUsuario);
            }
            
            session.setAttribute("contactos", contactos);
            response.sendRedirect("principal.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}