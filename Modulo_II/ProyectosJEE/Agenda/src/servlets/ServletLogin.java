package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import negocio.GestionUsuarios;

/**
 * Servlet implementation class HolaDinamico
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestionUsuarios gestionUsuarios;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        gestionUsuarios = new GestionUsuarios();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String passw = request.getParameter("passw");
		
		if(gestionUsuarios.validarUsuario(nombre, passw)){
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("login", nombre);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/ServletContactos");
			rd.forward(request,response);
		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}