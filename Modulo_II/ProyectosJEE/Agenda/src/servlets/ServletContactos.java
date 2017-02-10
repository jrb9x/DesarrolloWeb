package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Persona;
import negocio.Agenda;


/**
 * Servlet implementation class HolaDinamico
 */
@WebServlet("/ServletContactos")
public class ServletContactos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Agenda agenda;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletContactos() {
        super();
        agenda = new Agenda();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion= request.getSession(false);
		
		ArrayList<Persona> contactos;
		
		if(sesion==null){
			response.sendRedirect("/login.html");
		}else{
			String nombreUsuario= (String)sesion.getAttribute("login");
			PrintWriter out =response.getWriter();
			
			out.print("<!DOCTYPE html>"+
			"<html>"+
				"<head>"+
				"<meta charset=\"utf-8\">"+
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"./Styles/estilosPrincipal.css\">"+
				"<link href=\"https://fonts.googleapis.com/css?family=Righteous\" rel=\"stylesheet\">"+
				"</head>"+
				"<body>"+
				"<main>"+
				"<header>"+
				"<table>"+
				"<tr>"+
				"<td><div id=\"titulo\">Bienvenido " + nombreUsuario + "</div></td>"+
				"<td><div id=\"logout\"><a href=\"ServletLogout\"><img title=\"Logout\" src=\"iconos/logout.png\" width=\"35px\" height=\"35px\"></a></div></td>"+
				"</tr>"+
				"</table>"+			
				"</header>"+
				"<section id=\"contactos\">"+
				"<a href=\"ServletGestionContactos?usuario=" + nombreUsuario +"\"><img src=\"iconos/aniadir.png\" width=\"100px\" height=\"100px\"/></a>"+
				"<h2>Tus contactos:</h2>"+
				"<form action=\"ServletContactos\">"+
				"<label> Filtrar por mes:</label><select name=\"mes\">"+
				"<option name=\"mes\" value=\"01\">Enero</option>"+
				"<option name=\"mes\" value=\"02\">Febrero</option>"+
				"<option name=\"mes\" value=\"03\">Marzo</option>"+
				"<option name=\"mes\" value=\"04\">Abril</option>"+
				"<option name=\"mes\" value=\"05\">Mayo</option>"+
				"<option name=\"mes\" value=\"06\">Junio</option>"+
				"<option name=\"mes\" value=\"07\">Julio</option>"+
				"<option name=\"mes\" value=\"08\">Agosto</option>"+
				"<option name=\"mes\" value=\"09\">Septiembre</option>"+
				"<option name=\"mes\" value=\"10\">Octubre</option>"+
				"<option name=\"mes\" value=\"11\">Noviembre</option>"+
				"<option name=\"mes\" value=\"12\">Diciembre</option>"+
				"</select>"+
				"<input type=\"submit\" value=\"Filtrar\">"+
				"</form>"+
				"<table id=\"tablaContactos\">"+
				"<tr>"+
				"<th>Nombre</th>"+
				"<th>Apellidos</th>"+
				"<th>DNI</th>"+
				"<th>Telefono</th>"+
				"<th>Fecha Nacimiento</th>"+
				"<th>Modificar</th>"+
				"<th>Eliminar</th></tr>"
			);
		String mes = request.getParameter("mes");
		if(mes == null){
			contactos = agenda.recuperarAgenda(nombreUsuario);
		}
		else{
			contactos = agenda.recuperarCumplenEnDe(mes, nombreUsuario);
		}
		for (Persona persona : contactos) {
			out.print("<tr><td>" + persona.getNombre() + "</td>"+
					"<td>" + persona.getApellidos() + "</td>"+
					"<td>" + persona.getDni() + "</td>"+
					"<td>" + persona.getTelefono() + "</td>"+
					"<td>" + persona.getFecha() + "</td>"+
					"<td><a href=\"ServletGestionContactos?idModificar=" + persona.getId() + "\"><img title=\"Modificar\" src=\"iconos/modificar.png\" width=\"25px\" height=\"25px\"></a></td>"+
					"<td><a href=\"ServletEliminar?idEliminar=" + persona.getId() + "\"><img title=\"eliminar\" src=\"iconos/eliminar.png\" width=\"25px\" height=\"25px\"></a></td></tr>");
		}
		
		out.println("</table>"+
				 "</body>"+
				"</html>");
			
			
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