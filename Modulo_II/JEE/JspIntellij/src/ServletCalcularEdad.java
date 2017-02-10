import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

/**
 * ServletForward implementation class HolaDinamico
 */
@WebServlet("/ServletCalcularEdad")
public class ServletCalcularEdad extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCalcularEdad() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNac = LocalDate.parse(request.getParameter("fecha"));
        Period anio = Period.between(fechaNac, fechaActual);

        request.setAttribute("años", String.valueOf(anio.getYears()));

        //TODO EJEMPLO CON FORWARD
        /*ServletContext context= getServletContext();
        RequestDispatcher rd= context.getRequestDispatcher("/nombre.jsp");
        rd.forward(request, response);*/

        //TODO EJEMPLO CON SENDREDIRECT
        HttpSession session = request.getSession(false);
        session.setAttribute("nombre", request.getParameter("nombre"));
        session.setAttribute("años", String.valueOf(anio.getYears()));
        response.sendRedirect("/usuario.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}