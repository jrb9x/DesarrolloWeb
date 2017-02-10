package controlador;

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
	private GestionUsuarioRemote gestionUsuarios;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String nombre=request.getParameter("nombre");
		String password= request.getParameter("password");
		
		Usuario usuario = gestionUsuarios.loginUsuario(nombre, password);
		if(usuario != null){
			
			HttpSession session= request.getSession(true);			
			
			session.setAttribute("usuarioLogado", usuario);
			response.sendRedirect("ServletPrincipal");
			//response.sendRedirect("ServletGestionarPelicula");
				
		}else{
			
			request.getRequestDispatcher("mensaje.jsp?head=Login&msg=Datos introducidos incorrectos.").forward(request, response);
			
		}

	}

}