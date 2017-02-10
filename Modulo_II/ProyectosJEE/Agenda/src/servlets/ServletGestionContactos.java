package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.Agenda;
import beans.Persona;

/**
 * Servlet implementation class ServletGestionContactos
 */
@WebServlet("/ServletGestionContactos")
public class ServletGestionContactos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Agenda agenda;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionContactos() {
        super();
        agenda= new Agenda();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idModificar");
		String usuario = request.getParameter("usuario");
		String mes = request.getParameter("mes");
		
		String nombre = "";
		String apellidos = "";
		String dni = "";
		String telefono = ""; 
		String fecha = "";
		
		System.out.println(mes);
		
		if(id != null){
			Persona contacto =agenda.buscarPersonaPorId(new Integer(id));
			nombre = contacto.getNombre();
			apellidos = contacto.getApellidos();
			dni = contacto.getDni();
			telefono= contacto.getTelefono();
			fecha = contacto.getFecha().getDia() + "/" + contacto.getFecha().getMes() + "/" +contacto.getFecha().getAnio();
		}
		
		PrintWriter out=response.getWriter();
		out.print(
		"<!DOCTYPE html>"+
		"<html>"+
		"<head>"+
		"<meta charset=\"UTF-8\">"+
		"<title>Agenda</title>"+
		"</head>"+
		"<body>"+
		"<section id=\"nuevoContacto\">"+
		"<h2>Editar Contactos</h2>"+
		"<div id=\"formulario\">"+
		"<form id=\"contacto\" action=\"ServletGuardarContacto\" method=\"POST\" >"+
		"<label for=\"nombreContacto\">Nombre: </label><input value=\"" + nombre + "\" type=\"text\" name=\"nombre\" id=\"nombreContacto\" tabindex=\"1\"></input>" +
		"<label for=\"apellidosContacto\">Apellidos: </label><input value=\"" + apellidos + "\" type=\"text\" name=\"apellidos\" id=\"apellidosContacto\" tabindex=\"2\"></input>" +
		"<label for=\"dniContacto\">DNI: </label><input value=\"" + dni + "\" type=\"text\" name=\"dni\" id=\"dniContacto\" tabindex=\"3\"></input>" +			
		"<label for=\"telefonoContacto\">Telefono: </label><input value=\"" + telefono + "\" type=\"text\" name=\"telefono\" id=\"telefonoContacto\" tabindex=\"4\"></input>" +
		"<label for=\"emailContacto\">Fecha: </label><input value=\"" + fecha + "\" type=\"text\" name=\"fecha\" id=\"fechaContacto\" tabindex=\"5\"></input>" +
		"<input name=\"id\" type=\"hidden\" value=\"" + id + "\">" +
		"<input name=\"usuario\" type=\"hidden\" value=\"" + usuario + "\">" +
		"<button type=\"submit\" onclick=\"submit(this)\" tabindex=\"6\">Guardar</button>"+
		"</form><br>"+
		"</div>"+
		"</section>"+
		"</body>"+
		"</html>");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
