package dao;

import beans.Contacto;
import beans.Usuario;

import java.net.UnknownHostException;
import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

@Repository
public class UsuarioDaoMongoDB implements IUsuarioDao {

	
	private MongoClient mongo;
	private DB db;
	private DBCollection collection;
	
	public UsuarioDaoMongoDB(){
		
		try {
			mongo = new MongoClient( "localhost" , 27017 );
			db = mongo.getDB("agendamongodb");
			collection = db.getCollection("usuario");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
    @Override
    public Usuario selectUsuario(String nombre){
    	DBObject searchQuery = new BasicDBObject();
    	searchQuery.put("nombre", nombre);

    	DBCursor cursor = collection.find(searchQuery);
    	DBObject usuario = cursor.next();
    	
    	ObjectId _id = (ObjectId) usuario.get("_id");
    	String name = (String) usuario.get("nombre");
    	String password = (String) usuario.get("password");
    	ArrayList<Contacto> contactos = (ArrayList<Contacto>) usuario.get("contacto");
    	
    	Usuario usuarioEncontrado = new Usuario(_id,name,password,contactos);
    	return usuarioEncontrado;
    }

    @Override
    public boolean insertUsuario(Usuario usuario) {
    	DBObject document = new BasicDBObject();
    	document.put("nombre", usuario.getNombre());
    	document.put("password", usuario.getPassword());
    	document.put("contacto", usuario.getContacto());
    	collection.insert(document);

        return true;
    }
}
