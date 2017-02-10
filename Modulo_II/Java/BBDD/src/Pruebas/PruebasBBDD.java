package Pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebasBBDD {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/pruebas","root","root");
			Statement st = conn.createStatement();
			//st.execute("CREATE TABLE Libros (id INT(11), title VARCHAR(64))");
			st.executeUpdate("Insert into libros values(1, \"El Quijote\" )");
			st.executeUpdate("Insert into libros values(2, \"Java 6\" )");
			st.executeUpdate("Insert into libros values(3, \"Struts 2\" )");
			st.executeUpdate("update libros set title= \"El Quijote 2\" where id = 1");
			
			ResultSet rs = st.executeQuery("select * from libros");
			while(rs.next()){
				System.out.println("El id " + rs.getInt(1) +
						" es " + rs.getString("title"));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
