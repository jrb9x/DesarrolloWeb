package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Usuario;
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
		String password = request.getParameter("password");
		
		Usuario usuario = new Usuario(nombre, password);
		
		if(gestionUsuarios.validarUsuario(usuario)){
			HttpSession session = request.getSession(true);
			session.setAttribute("usuario", usuario);
			
			response.sendRedirect("ServletPrincipal");
		}else{
			response.sendRedirect("index.jsp?msg=Usuario y/o password incorrectos");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
