package ejerciciosql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		/*
		 * Realiza diversas actualizaciones en las distintas tablas de la base de datos
		 * institutodb.
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
			query = "UPDATE Estudiantes " + "SET nombre = 'Daniel' " + "WHERE nombre = 'Pablo'";

			// Ejecutamos el update.
			modRows = st.executeUpdate(query);

			// Imprimimos las filas modificadas.
			System.out.println("Has modificado un total de: " + modRows + " filas.");

			// Cogemos la excepción.
		} catch (SQLException e) {

			// Imprimimos la excepción.
			System.out.println(e.getMessage());
		}
	}
}