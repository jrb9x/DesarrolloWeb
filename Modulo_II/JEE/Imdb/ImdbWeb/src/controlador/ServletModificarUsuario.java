package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Pelicula;
import beans.Usuario;
import negocio.GestionUsuarioRemote;

@WebServlet("/ServletModificarUsuario")
public class ServletModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private GestionUsuarioRemote gestionUsuarios;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Integer id = ((Usuario) session.getAttribute("usuarioLogado")).getId();
		String nombre= request.getParameter("nombre");
		String password= request.getParameter("password");
		List<Pelicula> listaPeliculasFavoritas = new ArrayList<Pelicula>();
		Usuario usuario = new Usuario(nombre, password, listaPeliculasFavoritas);
		usuario.setId(id);
		
		if(gestionUsuarios.modificarUsuario(usuario)){
			/*RequestDispatcher requestDispatcher= getServletContext().getRequestDispatcher("/principal.jsp");
			response.getWriter().print("<p> Ha combiado su nombre de usuario correctamente </p>");
			requestDispatcher.include(request, response);*/
			session.setAttribute("usuarioLogado", usuario);
			request.getRequestDispatcher("principal.jsp").forward(request, response);
		}else{
			RequestDispatcher requestDispatcher= getServletContext().getRequestDispatcher("/principal.jsp");
			response.getWriter().print("<p style=\"color:red\"> Error, ese nombre de usuario ya existe </p>");
			requestDispatcher.include(request, response);
		}
	}
}
