package sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class Ejercicio1 {
	public static void main(String[] args) {

		// Guardamos las credenciales.
		String url = "jdsb:mysql://localhost/institutodb";
		String usuario = "root";
		String contraseña = "123";

		// Creamos la conexión.
		Connection conex = DriverManager.getConnection(url, usuario, contraseña);

		// Creamos un Statement.
		Statement st = conex.createStatement();
		
		// Creamos un insert.
		in

	}
}
