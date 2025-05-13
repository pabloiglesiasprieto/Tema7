package ejerciciosql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio6 {
	public static void main(String[] args) {

		/**/

		// Declaramos las credenciales.
		final String URL = "jdbc:mysql://localhost/institutodb";
		final String USERNAME = "root";
		final String PASSWD = "123";

		// Declaramos la variable que mostrará las filas modificadas.
		int modRows = 0;

		// Declaramos la cadena que almacenará el query.
		String query = "update calificaciones set nota = nota + 1 where id_estudiante = (select id_estudiante from estudiantes where nombre = 'Ana') ";

		// Iniciamos la conexión.
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWD)) {

			// Creamos la sentencia.
			Statement st = con.createStatement();

			// Ejecutamos la sentencia.
			modRows = st.executeUpdate(query);

			// Cogemos la excepción.
		} catch (SQLException e) {

			// Imprimimos la excepción.
			System.out.println(e);
		}

		// Imprimimos las filas añadidas.
		System.out.println("Has modificado un total de " + modRows + " lineas modificadas.");

	}
}
