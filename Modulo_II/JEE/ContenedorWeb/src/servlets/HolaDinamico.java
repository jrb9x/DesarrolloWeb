package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HolaDinamico
 */
@WebServlet("/HolaDinamico")
public class HolaDinamico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolaDinamico() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		String date = request.getParameter("fecha");
		int edad = calcularAnioLocalDate(date);
	
		response.getWriter().append("<h1>Hola "+ nombre +"</h1>");
		response.getWriter().append("<h3>tienes "+ edad +" a�os</h3>");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public int calcularAnio(String fecha) {
		   //probar localdate
	    Date fechaActual = new Date();
	    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	    String hoy = formato.format(fechaActual);
	    String[] dat1 = fecha.split("-");
	    String[] dat2 = hoy.split("-");
	    int anos = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
	    int mes = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
	    if (mes < 0) {
	      anos = anos - 1;
	    } else if (mes == 0) {
	      int dia = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
	      if (dia > 0) {
	        anos = anos - 1;
	      }
	    }
	    return anos;
	  }
	
	public int calcularAnioLocalDate(String fecha){
		LocalDate fechaActual = LocalDate.now();
		LocalDate fechaNacimiento = LocalDate.parse(fecha);
		int anios = fechaActual.getYear() - fechaNacimiento.getYear();
		int mes = fechaActual.getMonthValue() - fechaNacimiento.getMonthValue();
		if (mes < 0) {
			anios = anios - 1;
		} else if (mes == 0) {
			int dia = fechaActual.getDayOfMonth() - fechaNacimiento.getDayOfMonth();
			if (dia < 0){
				anios = anios - 1;
			}
		}
		return anios;
		
	}
}
