package dao;

/*
 * http://www.javahotchocolate.com/notes/mongodb-crud.html
 * http://www.mkyong.com/mongodb/java-mongodb-hello-world-example/
 * 
 */

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import beans.Contacto;
import beans.Usuario;

@Repository
public class ContactoDaoMongoDB implements IContactoDao{

	private MongoClient mongo;
	private DB db;
	private DBCollection collection;
	
	public ContactoDaoMongoDB(){
		
		try {
			mongo = new MongoClient( "localhost" , 27017 );
			db = mongo.getDB("agendamongodb");
			collection = db.getCollection("contacto");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public boolean guardarContacto(Contacto contacto, Usuario usuario) {
			
		List<Contacto> contactoList = ListarContactosDe(usuario);

		contactoList.add(contacto);
			
		//usuario.setContacto(contactoList);
		
		
		BasicDBObject document = new BasicDBObject();
    	document.put("nombre", contacto.getNombre());
    	document.put("apellidos", contacto.getApellidos());
    	document.put("dni", contacto.getDni());
    	document.put("telefono", contacto.getTelefono());
    	document.put("fecha", contacto.getFecha());
    	
    	collection.insert(document);
    	

    	BasicDBObject newDocument = new BasicDBObject();
    	newDocument.put("name", "mkyong-updated");

    	BasicDBObject updateObj = new BasicDBObject();
    	updateObj.put("$set", newDocument);

    	table.update(query, updateObj);
    	

        return true;
    }
	
	public Contacto recuperarPersona(Integer id) {
		
		Query query = new Query().addCriteria(Criteria.where("_id").is(id));
		Contacto contacto = mongoTemplate.findOne(query, Contacto.class);
       	
        return contacto;
	}
	
	public List<Contacto> ListarContactosDe(Usuario usuario) {
		
		Query query = new Query().addCriteria(Criteria.where("nombre").is(usuario.getNombre()));
		
		List<Contacto> resultados = mongoTemplate.find(query, Contacto.class);
        
        return resultados;
		
	}
	
	public boolean borrarContacto(Integer id){
		
      /*  Contacto contacto = em.find(Contacto.class, id);
    
        em.remove(contacto);*/
        
        return true;

	}

	@Override
	public boolean actualizarContacto(Contacto contacto) {
        
        //em.merge(contacto);

        return true;
	}
}
