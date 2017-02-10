package ejemplo;

import java.time.LocalDate;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import beans.Persona;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private int edad;
	private String password;
	private String mensaje;
	private LocalDate hoy;
	
	@Override
	public String execute(){
		if(edad>=18){
			mensaje="";
			
			ValueStack stack = ActionContext.getContext().getValueStack();
			stack.push(new Persona("paco",50));//<s:debug/>
			stack.findValue("nombre");
			//stack.pop();
			
			return SUCCESS;
		}else{
			mensaje="Eres menor de edad";
			return LOGIN;
		}
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public LocalDate getHoy() {
		return hoy;
	}

	public void setHoy(LocalDate hoy) {
		this.hoy = hoy;
	}
	
	@Override
	public String toString() {
		return "LoginAction";
	}
	
	
}
