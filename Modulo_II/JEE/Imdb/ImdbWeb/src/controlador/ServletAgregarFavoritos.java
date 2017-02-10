package controlador;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Pelicula;
import beans.Usuario;
import negocio.GestionUsuarioRemote;



@WebServlet("/ServletAgregarFavoritos")
public class ServletAgregarFavoritos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private GestionUsuarioRemote gestionUsuarios;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession(false);
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		List<Pelicula> listaFavoritos = usuario.getListaPeliculasFavoritas();
		Pelicula pelicula = (Pelicula) session.getAttribute("pelicula");
		listaFavoritos.add(pelicula);
		
		/*Usuario aux = new Usuario(usuario.getNombre(), usuario.getNombre(),listaFavoritos);
		aux.setId(usuario.getId());
		
		gestionUsuarios.modificarUsuario(aux);*/
		request.getRequestDispatcher("ServletMostrarPeliculas?idMostrar="+pelicula.getId()).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
