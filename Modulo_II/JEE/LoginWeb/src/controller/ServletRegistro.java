package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.GestionUsuarioRemote;

@WebServlet("/ServletRegistro")
public class ServletRegistro extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private GestionUsuarioRemote gestionUsuario;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");
        
        boolean registrado = gestionUsuario.aniadirUsuario(nombre,password);

        if(registrado){
            response.sendRedirect("login.html");
        }
        else{
        	response.sendRedirect("login.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}