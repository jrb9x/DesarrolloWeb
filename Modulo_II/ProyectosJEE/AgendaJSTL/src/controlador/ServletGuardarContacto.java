package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Agenda;
import modelo.GestionUsuarios;
import beans.Fecha;
import beans.Usuario;
import beans.Contacto;

/**
 * Servlet implementation class ServletGuardarContacto
 */
@WebServlet("/ServletGuardarContacto")
public class ServletGuardarContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Agenda agenda;
       GestionUsuarios gestionUsuarios;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGuardarContacto() {
        super();
        agenda= new Agenda();
        gestionUsuarios = new GestionUsuarios();
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
			HttpSession session = request.getSession(false);
			
			String user = (String) session.getAttribute("login");
			String passw = (String) session.getAttribute("passw");
			
			Usuario usuario = new Usuario(user,passw);
			
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			String dni = request.getParameter("dni");
			String telefono = request.getParameter("telefono");
			Fecha fecha = new Fecha(request.getParameter("fecha"));
			String id = request.getParameter("id");
			
			if(id.equals("null")){
				agenda.aniadirPersona(new Contacto(null,nombre,apellidos,dni,telefono,fecha), usuario);
			}else{
				//gestionUsuarios.modificarContacto(new Contacto(Integer.parseInt(id),nombre,apellidos,dni,telefono,fecha));
			}
			response.sendRedirect("ServletPrincipal");
	}

}
