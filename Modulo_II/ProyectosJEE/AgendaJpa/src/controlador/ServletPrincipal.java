package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Contacto;
import beans.Usuario;
import modelo.Agenda;

@WebServlet("/ServletPrincipal")
public class ServletPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Agenda agenda;
	
    public ServletPrincipal() {
        super();
        agenda = new Agenda();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		ArrayList<Contacto> contactos = new ArrayList<>();
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String mes = request.getParameter("mes");

		if(mes == null)
            contactos = agenda.recuperarAgenda(usuario);
            
		else if(mes.equals("00"))
			contactos = agenda.recuperarAgenda(usuario);
            
		else
			contactos = agenda.recuperarCumplenEnDe(mes, usuario);
            
		session.setAttribute("listaContactos", contactos);
        response.sendRedirect("principal.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
