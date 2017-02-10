package beans;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Usuario {
	
	@Id
	private ObjectId _id;
	private String nombre;
	private String password;
	private ArrayList<Contacto> contacto;
	
	public Usuario() {
		super();
	}
		
	public Usuario(String nombre, String password) {
		super();
		this.nombre = nombre;
		this.password = password;
	}

	public Usuario(ObjectId _id, String nombre, String password, ArrayList<Contacto> contacto) {
		super();
		this._id = _id;
		this.nombre = nombre;
		this.password = password;
		this.contacto = contacto;
	}

	public ObjectId getId() {
		return _id;
	}

	public void setId(ObjectId _id) {
		this._id = _id;
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

	public ArrayList<Contacto> getContacto() {
		return contacto;
	}

	public void setContacto(ArrayList<Contacto> contacto) {
		this.contacto = contacto;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", password=" + password + "]";
	}
	
}
