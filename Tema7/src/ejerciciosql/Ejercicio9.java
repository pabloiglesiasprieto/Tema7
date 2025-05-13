package ejerciciosql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {

		// Declaramos las variables para las credenciales de la BBDD.
		final String URL = "jdbc:mysql://localhost/institutodb";
		final String USERNAME = "root";
		final String PASSWD = "123";

		// Creamos un Scanner.
		Scanner sc = new Scanner(System.in);

		// Declaramos una variable para una consulta.
		String query = "select nombre, fecha_nacimiento from estudiantes";

		// Creamos una conexión.
		try (Connection conex = DriverManager.getConnection(URL, USERNAME, PASSWD)) {

			// Creamos un Statement.
			Statement st = conex.createStatement();

			// Ejecutamos la sentencia.
			ResultSet rs = st.executeQuery(query);

			// Imprimimos las cabeceras.
			System.out.println("Nombre\t   Fecha\n------------------------");

			// Imprimimos los resultados.
			while (rs.next()) {

				// Imprimimos el resultado.
				System.out.println(rs.getString(1) + "\t | " + rs.getString(2));
				System.out.println("------------------------");

			}

			// Recogemos la excepción.
		} catch (SQLException e) {

			// Imprimimos la excepción.
			System.out.println(e);

		}
	}
}
