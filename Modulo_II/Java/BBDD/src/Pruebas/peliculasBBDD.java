package Pruebas;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class peliculasBBDD {

	public static void main(String[] args) {
		try {
			
			Connection conn = AgenteConexion.getAgenteConexion("peliculas").conexion;
			Statement st = conn.createStatement();
			
			st.execute("drop table venta");
			st.execute("drop table pelicula");
			
			st.execute("CREATE TABLE pelicula (id_pelicula INT(6) primary key, title VARCHAR(25))");
			st.execute("CREATE TABLE venta (id_pelicula INT(6), fecha_compra DATE DEFAULT '2000-01-01', unidades INT(4), " +
						"CONSTRAINT FK_ID_PELICULAS FOREIGN KEY (id_pelicula) " +
						"REFERENCES pelicula(id_pelicula) " +
						"ON UPDATE CASCADE " +
						"ON DELETE SET NULL)");
			st.executeUpdate("Insert into pelicula values(1, \"El señor de Java\" )");
			st.executeUpdate("Insert into pelicula values(2, \"Buscando en BBDD\" )");
			st.executeUpdate("Insert into venta values(1, '2013-01-01', 1000)");
			st.executeUpdate("Insert into venta values(2, '2016-01-01', 2906)");
			ResultSet rs = st.executeQuery("select * from pelicula, venta");
			
			while(rs.next()){
				System.out.println(rs.getString("title") +
						", fecha de compra: " + rs.getString("fecha_compra") +
						", unidades: " + rs.getInt("unidades"));
			}
			st.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
