package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Usuario;
import negocio.GestionUsuarioRemote;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private GestionUsuarioRemote gestionUsuario;
 
    public ServletLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String passw = request.getParameter("password");
		
		Usuario usuario = gestionUsuario.loginUsuario(nombre, passw);
		HttpSession session = request.getSession(true);
		session.setAttribute("login", usuario.getNombre());
		session.setAttribute("passw", usuario.getPassword());
			
		response.sendRedirect("principal.jsp");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}