package ejerciciosql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {

		/*
		 * Realiza una aplicación que solicite todos los datos de un alumno y lo inserte
		 * en la base de datos.
		 */
		// Declaramos las variables para las credenciales de la BBDD.
		final String URL = "jdbc:mysql://localhost/institutodb";
		final String USERNAME = "root";
		final String PASSWD = "123";

		// Creamos un Scanner.
		Scanner sc = new Scanner(System.in);

		// Declaramos una variable para una consulta.
		String query = "";

		// Declaramos variables para insertar datos.
		int id;

		// Declaramos una variable para ver las filas modificadas.
		int modRows = 0;

		// Creamos una conexión.
		try (Connection conex = DriverManager.getConnection(URL, USERNAME, PASSWD)) {

			// Creamos un Statement.
			Statement st = conex.createStatement();

			// Preguntamos los datos.
			System.out.println("Introduce el id.");

			// Leemos entrada de teclado.
			id = sc.nextInt();

			// Guardamos la sentencia.
			query = "delete from estudiantes where id_estudiante = " + id;

			// Ejecutamos la sentencia.
			modRows = st.executeUpdate(query);

			// Recogemos la excepción.
		} catch (SQLException e) {

			// Imprimimos la excepción.
			System.out.println(e);

		}

		// Imprimimos las filas borradas.
		System.out.println("Has borrado un total de " + modRows + " filas.");
	}
}
