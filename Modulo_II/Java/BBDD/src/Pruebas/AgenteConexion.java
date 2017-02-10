package Pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AgenteConexion {
	
	protected static AgenteConexion mInstancia = null;
	protected Connection conexion;
	protected AgenteConexion(String nombreDB) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/"+ nombreDB, "root","root");
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static AgenteConexion getAgenteConexion(String nombreDB) {
	
		if (mInstancia == null) {
			mInstancia = new AgenteConexion(nombreDB);
		}
		return mInstancia;
	}
}
