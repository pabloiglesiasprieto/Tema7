package ejerciciosql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio3 {
	public static void main(String[] args) {

		/*
		 * Realiza una eliminación de registro en las distintas tablas de la base de
		 * datos institutodb.
		 */
		// Declaramos las variables para las credenciales de la BBDD.
		final String URL = "jdbc:mysql://localhost/institutodb";
		final String USERNAME = "root";
		final String PASSWD = "123";

		// Declaramos una variable para una consulta.
		String query = "";

		// Declaramos una variable para ver las filas modificadas.
		int modRows;

		// Creamos una conexión.
		try (Connection conex = DriverManager.getConnection(URL, USERNAME, PASSWD)) {

			// Creamos un Statement.
			Statement st = conex.createStatement();

			// Creamos la consulta.
			query = "DELETE FROM Estudiantes " + "WHERE nombre = 'Daniel'";

			// Ejecutamos el update.
			modRows = st.executeUpdate(query);

			// Imprimimos las filas modificadas.
			System.out.println("Has borrado un total de: " + modRows + " filas.");

			// Cogemos la excepción.
		} catch (SQLException e) {

			// Imprimimos la excepción.
			System.out.println(e.getMessage());
		}
	}
}
