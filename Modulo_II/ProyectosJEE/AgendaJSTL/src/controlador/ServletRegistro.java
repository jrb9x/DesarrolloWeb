package controlador;



import beans.Usuario;
import modelo.GestionUsuarios;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletRegistro")
public class ServletRegistro extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletRegistro() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String password = request.getParameter("passw");

        GestionUsuarios usuarioNuevo = new GestionUsuarios();
        
        
        Usuario usuario = new Usuario(nombre,password);

        boolean registrado = usuarioNuevo.registrarUsuario(usuario);

        if(registrado){
            response.sendRedirect("index.jsp");
        }
        else{
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp?msg=Fallo en el registro");
            rd.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}