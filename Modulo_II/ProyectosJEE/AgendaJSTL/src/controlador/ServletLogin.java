package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.GestionUsuarios;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestionUsuarios gestionUsuarios;
 
    public ServletLogin() {
        super();
        gestionUsuarios = new GestionUsuarios();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String passw = request.getParameter("passw");
		
		if(gestionUsuarios.validarUsuario(nombre, passw)){
			HttpSession session = request.getSession(true);
			session.setAttribute("login", nombre);
			session.setAttribute("passw", passw);
			
			response.sendRedirect("ServletPrincipal");
		}else{
            response.sendRedirect("index.jsp?error=Usuario y/o contraseña incorrectos");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}