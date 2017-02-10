package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HolaDinamico
 */
@WebServlet("/HolaDinamico2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
PrintWriter writer = response.getWriter();
		
		HttpSession sesion = request.getSession(true);
		
		String nombre = request.getParameter("nombre");
		String date = request.getParameter("fecha");
		
		sesion.setAttribute("login", nombre);
		sesion.setMaxInactiveInterval(20);
		//int edad = calcularAnioLocalDate(date);
		LocalDate fechaActual = LocalDate.now();
		LocalDate fechaNacimiento = LocalDate.parse(date);
		
		Period edad = Period.between(fechaNacimiento, fechaActual);

		response.setContentType("text/html");
		
		writer.append("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Hola Mundo Estatico!</title></head><body>");
		writer.append("Nombre: "+ nombre +"<br>");
		writer.append("Edad: "+ edad.getYears() +"<br>");
		writer.append("<a href=\"HolaDinamico2\">Siguiente pagina</a>");		
		writer.append("</body></html>");
		
		writer.append("Served at: ").append(request.getContextPath());
		writer.close();
		
		//*********************
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		
		out.print("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Hola Mundo Estatico!</title></head><body>");
		if(session == null){
			out.print("No ha iniciado sesion");
		}
		else{
			nombre = (String)session.getAttribute("login");
			out.println("Hola " + nombre + " gracias");
			out.print("</body></html>");
			out.close();
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

