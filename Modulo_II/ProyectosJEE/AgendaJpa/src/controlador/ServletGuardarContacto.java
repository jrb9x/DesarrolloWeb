package controlador;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Contacto;
import beans.Usuario;
import modelo.Agenda;


@WebServlet("/ServletGuardarContacto")
public class ServletGuardarContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Agenda agenda;

    public ServletGuardarContacto() {
    	super();
    	agenda= new Agenda();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		String id = (String) request.getParameter("id");
		
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String dni = request.getParameter("dni");
		String telefono = request.getParameter("telefono");
		LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
		
		if(id.equals("null"))
			agenda.aniadirPersona(new Contacto(null,nombre,apellidos,dni,telefono,fecha), usuario);
		else
			agenda.modificarContacto(new Contacto(Integer.parseInt(id),nombre,apellidos,dni,telefono,fecha));
		
		response.sendRedirect("ServletPrincipal");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
