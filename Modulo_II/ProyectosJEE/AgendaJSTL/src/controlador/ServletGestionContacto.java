package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Agenda;
import beans.Contacto;

/**
 * Servlet implementation class ServletGestionContacto
 */
@WebServlet("/ServletGestionContacto")
public class ServletGestionContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Agenda agenda;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionContacto() {
        super();
        agenda= new Agenda();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("idModificar");
		
		if (id != null) {
			Contacto contacto = agenda.buscarPersonaPorId(new Integer(id));

			String nombre = contacto.getNombre();
			String apellidos = contacto.getApellidos();
			String dni = contacto.getDni();
			String telefono = contacto.getTelefono();
			String fecha = contacto.getFecha().getDia() + "/" + contacto.getFecha().getMes() + "/" + contacto.getFecha().getAnio();
			
			System.out.println(nombre);
			
			session.setAttribute("nombreContacto", nombre);
			session.setAttribute("apellidoContacto", apellidos);
			session.setAttribute("dniContacto", dni);
			session.setAttribute("telefonoContacto", telefono);
			session.setAttribute("fechaContacto", fecha);
			
	        response.sendRedirect("formularioContacto.jsp");
		}
		else
			response.sendRedirect("formularioContacto.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
