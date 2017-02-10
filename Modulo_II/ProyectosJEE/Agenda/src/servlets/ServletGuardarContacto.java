package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.Agenda;
import beans.Fecha;
import beans.Persona;

/**
 * Servlet implementation class ServletGuardarContacto
 */
@WebServlet("/ServletGuardarContacto")
public class ServletGuardarContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Agenda agenda;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGuardarContacto() {
        super();
        agenda= new Agenda();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String usuario = request.getParameter("usuario");
			
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			String dni = request.getParameter("dni");
			String telefono = request.getParameter("telefono");
			Fecha fecha = new Fecha(request.getParameter("fecha"));
			String id = request.getParameter("id");
			
			if(id.equals("null")){
				agenda.aniadirPersona(new Persona(-1,nombre,apellidos,dni,telefono,fecha), usuario);
			}else{
				agenda.modificarPersona(new Persona(Integer.parseInt(id),nombre,apellidos,dni,telefono,fecha));
			}
			response.sendRedirect("ServletContactos");
	}

}
